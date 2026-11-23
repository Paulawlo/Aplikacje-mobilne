import { after, before, test } from "node:test";
import { readFileSync } from "node:fs";
import { initializeTestEnvironment, assertFails, assertSucceeds } from "@firebase/rules-unit-testing";
import { doc, getDoc, setDoc } from "firebase/firestore";

let env;
before(async () => {
  env = await initializeTestEnvironment({ projectId: "demo-penguin", firestore: { rules: readFileSync("../../firestore.rules", "utf8") } });
  await env.withSecurityRulesDisabled(async context => {
    const db = context.firestore();
    await setDoc(doc(db, "users/alice/entries/day1"), { sleepHours: 7 });
    await setDoc(doc(db, "groups/g1"), { name: "Pingwiny" });
    await setDoc(doc(db, "groups/g1/members/alice"), { role: "owner" });
    await setDoc(doc(db, "groups/g1/members/bob"), { role: "member" });
    await setDoc(doc(db, "groups/g1/publicProgress/day1"), { habit: "Sen", status: "done" });
    await setDoc(doc(db, "groups/g1/penguins/p1"), { health: 7 });
  });
});
after(async () => { if (env) await env.cleanup(); });
const user = uid => env.authenticatedContext(uid).firestore();

test("właściciel czyta własne dane prywatne", async () => {
  await assertSucceeds(getDoc(doc(user("alice"), "users/alice/entries/day1")));
});
test("znajomy i anonim nie czytają prywatnego wpisu", async () => {
  await assertFails(getDoc(doc(user("bob"), "users/alice/entries/day1")));
  await assertFails(getDoc(doc(env.unauthenticatedContext().firestore(), "users/alice/entries/day1")));
});
test("członek czyta grupę i publiczny postęp", async () => {
  await assertSucceeds(getDoc(doc(user("bob"), "groups/g1")));
  await assertSucceeds(getDoc(doc(user("bob"), "groups/g1/publicProgress/day1")));
});
test("obca osoba nie czyta grupy ani publicznego postępu", async () => {
  await assertFails(getDoc(doc(user("eve"), "groups/g1")));
  await assertFails(getDoc(doc(user("eve"), "groups/g1/publicProgress/day1")));
});
test("klient nie dopisuje członkostwa ani nie modyfikuje pingwina", async () => {
  await assertFails(setDoc(doc(user("eve"), "groups/g1/members/eve"), { role: "member" }));
  await assertFails(setDoc(doc(user("alice"), "groups/g1/penguins/p1"), { health: 700 }));
});
test("klient nie zapisuje własnego wyniku ani nie tworzy nieznanych dokumentów", async () => {
  await assertFails(setDoc(doc(user("alice"), "users/alice/entries/day1"), { sleepHours: 20 }));
  await assertFails(setDoc(doc(user("alice"), "invites/code"), { groupId: "g1" }));
});

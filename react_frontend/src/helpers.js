export const isPersistedState = stateName => {
  const sessionState = sessionStorage.getItem(stateName)
  return sessionState && JSON.parse(sessionState);
};

export const fetchUser = (user) => {
  return "placeHolder"
};

export const canSeeDormStudents = (userType) => {
  return userType === "schooladministrator" || userType === "healthstaff" || userType === "admin";

}

export const getBreakouts = (dorm) => {
  return  {"newBOuts": Math.round(Math.random()*100), "bOuts": Math.round(Math.random()*100)} // placeholder
}

export const getStudents = (user) => {
  return [
    "Burak Öztürk",
    "Arda İçöz",
    "Mustafa Tamyapar",
    "Melis Atun",
    "Onur Vural"
  ]
}
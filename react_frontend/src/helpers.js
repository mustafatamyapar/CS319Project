export const isPersistedState = stateName => {
  const sessionState = sessionStorage.getItem(stateName)
  return sessionState && JSON.parse(sessionState);
};

export const fetchUser = user => {
  return "placeHolder"
};
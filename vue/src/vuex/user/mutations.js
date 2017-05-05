export default {
  storeUser (state, { user }) {
    state.id = user.id;
    state.loggin = true;
  	state.user = user;
  }
}
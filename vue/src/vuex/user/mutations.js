export default {
  storeUser (state, { user }) {
    state.id = user.id;
    state.login = true;
  	state.user = user;
  }
}
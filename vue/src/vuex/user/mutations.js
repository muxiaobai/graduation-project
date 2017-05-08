export default {
  storeUser (state, { user }) {
    console.log(user);
    state.id = user.id;
    state.loggin = true;
  	state.user = user;
  }
}
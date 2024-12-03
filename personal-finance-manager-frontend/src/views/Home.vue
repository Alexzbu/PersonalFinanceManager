<template>
  <div class="home">
    <h1>Welcome to the Personal Finance Manager</h1>
    <p>This application helps you manage your personal finances by tracking transactions and planning budgets.</p>
    <button @click="goToLogin" v-if="!isLoggedIn">Login</button>
    <button @click="goToRegister" v-if="!isLoggedIn">Register</button>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
  props: ['isLoggedIn'],
  methods: {
      goToLogin() {
        this.$router.push('/login');
      },
      goToRegister() {
        this.$router.push('/register');
      }
  }
};
</script>

<style scoped>
.home {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
}

h1 {
  color: #444;
}

p {
  color: #666;
}

button {
  width: 30%;
  padding: 10px;
  margin-right: 10px;
  border: none;
  border-radius: 5px;
  background-color: #007bff;
  color: white;
  font-size: 16px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>

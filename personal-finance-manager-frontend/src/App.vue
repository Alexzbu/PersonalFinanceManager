<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/transactions">Transactions</router-link> |
      <router-link to="/budget">Budget Planner</router-link>
      <button @click="logout" v-if="isLoggedIn" class="logout-button">Logout</button>
    </nav>
    <router-view
      :isLoggedIn="isLoggedIn"
    />
  </div>
</template>

<script>
import apiServer from '@/api/index.js';
import Cookies from 'js-cookie';

export default {
  name: 'App',
  data() {
      return {
        isLoggedIn: !!Cookies.get('JSESSIONID')
      };
  },
  methods: {
    async logout() {
      try {
        const response = await apiServer.post('/logout');
        console.log('User logged out successfully:', response.data);
        this.isLoggedIn = false;
        this.$router.push('/');
      } catch (error) {
        console.error('Logout failed:', error);
      }
    },
    checkAuth() {
       this.isLoggedIn = !!Cookies.get('JSESSIONID');
    }
  },
  watch: {
     '$route': 'checkAuth'
  },
  created() {
    this.checkAuth();
  }
};
</script>

<style>
nav {
  padding: 20px;
  background-color: #f5f5f5;
  margin-bottom: 20px;
  display: flex;
  align-items: center;
}

nav a {
  font-size: 20px;
  margin-right: 15px;
  text-decoration: none;
  color: #007bff;
}

nav a:hover {
  text-decoration: underline;
}

.logout-button {
  font-size: 20px;
  margin-left: auto;
  padding: 5px 10px;
  background-color: #ff4d4d;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.logout-button:hover {
  background-color: #ff1a1a;
}
</style>

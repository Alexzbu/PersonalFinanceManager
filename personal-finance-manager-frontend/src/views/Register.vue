<template>
  <div>
    <h1>Register</h1>
    <form @submit.prevent="register">
      <div>
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="username">
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password">
      </div>
      <button type="submit">Register</button>
    </form>
  </div>
</template>

<script>
import apiClient from '@/api/index.js';

export default {
  name: 'RegisterView',
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    async register() {
                try {
                    const response = await apiClient.post('/auth/register', {
                        username: this.username,
                        password: this.password,
                    });
                    console.log('User registered successfully:', response.data);
                } catch (error) {
                    console.error('Error registering user:', error);
                }
            }
  }
}
</script>

<style scoped>
/* Додайте стилі за потреби */
</style>

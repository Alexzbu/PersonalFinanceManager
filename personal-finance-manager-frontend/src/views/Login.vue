<template>
  <div class="login-container">
    <h2>Login</h2>
    <form @submit.prevent="login">
      <div class="form-group">
        <label for="username">Email</label>
        <input
          type="text"
          id="username"
          v-model="username"
          :class="{ 'is-invalid': errors.username }"
        />
        <div v-if="errors.username" class="invalid-feedback">{{ errors.username }}</div>
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input
          type="password"
          id="password"
          v-model="password"
          :class="{ 'is-invalid': errors.password }"
        />
        <div v-if="errors.password" class="invalid-feedback">{{ errors.password }}</div>
      </div>
      <button type="submit">Login</button>
    </form>
    <div v-if="serverError" class="server-error">{{ serverError }}</div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'LoginView',
  data() {
    return {
      username: '',
      password: '',
      errors: {},
      serverError: ''
    };
  },
  methods: {
    validateForm() {
      this.errors = {};

      const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

      if (!this.username) {
        this.errors.username = 'Email is required';
      } else if (!emailPattern.test(this.username)) {
        this.errors.username = 'Invalid email format';
      }

      if (!this.password) {
        this.errors.password = 'Password is required';
      }

      return Object.keys(this.errors).length === 0;
    },
    async login() {
      if (!this.validateForm()) {
        return;
      }

      try {
              const response = await axios.post('http://localhost:8080/login', new URLSearchParams({
                  username: this.username,
                  password: this.password
              }), {
                  headers: {
                      'Content-Type': 'application/x-www-form-urlencoded'
                  },
                  withCredentials: true // Це дозволяє включити cookies в запит
              });

              console.log('User logged in successfully:', response.data);
              localStorage.setItem('JSESSIONID', response.headers['set-cookie']);
              this.$router.push('/');
          } catch (error) {
              console.error('Error logging in user:', error.response ? error.response.data : error.message);
          }
    }
  }
};
</script>

<style scoped>
.login-container {
  max-width: 400px;
  margin: 50px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #ffffff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
  color: #333;
}

input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-sizing: border-box;
  font-size: 14px;
}

button {
  width: 100%;
  padding: 10px;
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

.is-invalid {
  border-color: #dc3545;
}

.invalid-feedback {
  color: #dc3545;
  font-size: 0.875em;
  margin-top: 5px;
}

.server-error {
  color: #dc3545;
  margin-top: 15px;
  text-align: center;
}
</style>

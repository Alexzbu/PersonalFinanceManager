<template>
  <div class="register-container">
    <h2>Register</h2>
    <form @submit.prevent="register">
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
      <div class="form-group">
        <label for="confirmPassword">Confirm Password</label>
        <input
          type="password"
          id="confirmPassword"
          v-model="confirmPassword"
          :class="{ 'is-invalid': errors.confirmPassword }"
        />
        <div v-if="errors.confirmPassword" class="invalid-feedback">{{ errors.confirmPassword }}</div>
      </div>
      <button type="submit">Register</button>
    </form>
    <div v-if="serverError" class="server-error">{{ serverError }}</div>
  </div>
</template>

<script>
import apiServer from '@/api/index.js';

export default {
  name: 'RegisterView',
  data() {
    return {
      username: '',
      password: '',
      confirmPassword: '',
      errors: {},
      serverError: ''
    };
  },
  methods: {
    validateForm() {
      this.errors = {};

      const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      const passwordPattern = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;

      if (!this.username) {
        this.errors.username = 'Email is required';
      } else if (!emailPattern.test(this.username)) {
        this.errors.username = 'Invalid email format';
      }

      if (!this.password) {
        this.errors.password = 'Password is required';
      } else if (!passwordPattern.test(this.password)) {
        this.errors.password = 'Password must be at least 8 characters long and contain at least one letter and one number';
      }

      if (this.password !== this.confirmPassword) {
        this.errors.confirmPassword = 'Passwords do not match';
      }

      return Object.keys(this.errors).length === 0;
    },
    async register() {
      if (!this.validateForm()) {
        return;
      }

      try {
        const response = await apiServer.post('/api/auth/register', {
          username: this.username,
          password: this.password,
        });
        console.log('User registered successfully:', response.data);
        this.serverError = '';
        this.$router.push('/login');
      } catch (error) {
        if (error.response && error.response.data) {
          this.serverError = error.response.data.message;
        } else {
          this.serverError = 'An error occurred. Please try again.';
        }
        console.error('Error registering user:', error);
      }
    }
  }
};
</script>

<style scoped>
.register-container {
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

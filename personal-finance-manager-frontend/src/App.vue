<template>
  <div id="app">
    <nav>
      <router-link to="/add-transaction">Add Transaction</router-link>
      <router-link to="/budget-planner">Budget Planner</router-link>
      <router-link to="/transaction-list">Transaction List</router-link>
      <router-link to="/budget-list">Budget List</router-link>
    </nav>
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App'
};
</script>

<style>
nav {
  background-color: #333;
  padding: 10px;
}

nav a {
  color: #fff;
  margin: 0 10px;
  text-decoration: none;
}

nav a:hover {
  text-decoration: underline;
}
</style>

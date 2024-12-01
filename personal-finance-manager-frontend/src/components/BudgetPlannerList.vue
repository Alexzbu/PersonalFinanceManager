<template>
    <ul class="budget-list">
      <li v-for="item in budgetItems" :key="item.id" class="budget-item">
        {{ item.name }} - {{ item.amount }}
        <button @click="$emit('remove-budget-item', item.id)" class="button-remove">Remove</button>
      </li>
    </ul>
</template>

<script>
export default {
  name: 'BudgetPlannerList',
  props: ['budgetItems'],
};
</script>

<style scoped>
.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

h1 {
  color: #444;
}

.form-control {
  display: flex;
  flex-direction: column;
  margin-bottom: 20px;
}

.form-control input {
  margin-bottom: 10px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.button {
  padding: 10px 20px;
  color: #fff;
  background-color: #007bff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.button:hover {
  background-color: #0056b3;
}

.button-remove {
  background-color: #ff4d4d;
  padding: 5px 10px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  color: #fff;
}

.button-remove:hover {
  background-color: #cc0000;
}

.budget-list {
  list-style-type: none;
  padding: 0;
}

.budget-item {
  display: flex;
  justify-content: space-between;
  padding: 10px;
  border-bottom: 1px solid #ccc;
}

.budget-summary {
  margin-top: 20px;
}
</style>

<template>
  <div class="container">
    <h1>Budget List</h1>
    <ul class="budget-list">
      <li v-for="item in budgetItems" :key="item.id" class="budget-item">
        {{ item.name }} - {{ item.amount }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'BudgetList',
  data() {
    return {
      budgetItems: [
        { id: 1, name: 'Groceries', amount: 300 },
        { id: 2, name: 'Rent', amount: 1200 },
        { id: 3, name: 'Utilities', amount: 150 }
      ]
    };
  }
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

.budget-list {
  list-style-type: none;
  padding: 0;
}

.budget-item {
  padding: 10px;
  border-bottom: 1px solid #ccc;
}
</style>

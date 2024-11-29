<template>
  <div class="budget-planner">
    <h2>Budget Planner</h2>
    <form @submit.prevent="addBudgetItem" class="form">
      <input
        type="text"
        v-model="newBudgetItem.name"
        placeholder="Budget Item Name"
        class="form-control"
      />
      <input
        type="number"
        v-model="newBudgetItem.amount"
        placeholder="Amount"
        class="form-control"
      />
      <button type="submit" class="button">Add Budget Item</button>
    </form>
    <ul class="budget-list">
      <li v-for="item in budgetItems" :key="item.id" class="budget-item">
        {{ item.name }} - {{ item.amount }}
        <button @click="removeBudgetItem(item.id)" class="button-remove">Remove</button>
      </li>
    </ul>
    <div class="budget-summary">
      <p>Total Budget: {{ totalBudget }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'BudgetPlanner',
  data() {
    return {
      newBudgetItem: {
        name: '',
        amount: null,
      },
      budgetItems: [],
      nextId: 1,
    };
  },
  computed: {
    totalBudget() {
      return this.budgetItems.reduce((sum, item) => sum + item.amount, 0);
    },
  },
  methods: {
    addBudgetItem() {
      if (this.newBudgetItem.name && this.newBudgetItem.amount) {
        this.budgetItems.push({
          ...this.newBudgetItem,
          id: this.nextId++,
        });
        this.newBudgetItem.name = '';
        this.newBudgetItem.amount = null;
      }
    },
    removeBudgetItem(id) {
      this.budgetItems = this.budgetItems.filter(item => item.id !== id);
    },
  },
};
</script>

<style scoped>
.budget-planner {
  padding: 20px;
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin-bottom: 20px;
}

.budget-planner h2 {
  margin-top: 0;
}

.form {
  display: flex;
  flex-direction: column;
  margin-bottom: 20px;
}

.form-control {
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
  text-align: center;
  text-decoration: none;
  margin-top: 10px;
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
  font-weight: bold;
}
</style>

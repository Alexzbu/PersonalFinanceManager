<template>
  <div class="container">
    <h1>Budget Planner</h1>
    <AddBudgetPlannerItem @add-budget-item="addBudgetItem"/>
    <BudgetPlannerList :budgetItems="budgetItems" @remove-budget-item="removeBudgetItem"/>
    <div class="budget-summary">
      <p>Total Budget: {{ totalBudget }}</p>
      <p>Total Spent: {{ totalSpent }}</p>
      <p>Remaining Budget: {{ remainingBudget }}</p>
    </div>
  </div>
</template>

<script>
import AddBudgetPlannerItem from '@/components/AddBudgetPlannerItem.vue';
import BudgetPlannerList from '@/components/BudgetPlannerList.vue';
import apiClient from '@/api/index.js';

export default {
  name: 'BudgetPlanner',
  components: {
     AddBudgetPlannerItem,
     BudgetPlannerList
  },
  data() {
      return {
        budgetItems: [],
        transactions: []
      };
  },
  computed: {
    totalBudget() {
      return this.budgetItems.reduce((sum, item) => sum + item.amount, 0);
    },
    totalSpent() {
      return this.transactions.reduce((sum, transaction) => sum + transaction.amount, 0);
    },
    remainingBudget() {
      return this.totalBudget - this.totalSpent;
    }
  },
  methods: {
    fetchBudgetItems() {
       apiClient.get('/budget')
       .then(response => {
           this.budgetItems = response.data;
       })
       .catch(error => {
            console.error('Error fetching budget items:', error);
       });
    },
    fetchTransactions() {
       apiClient.get('/transactions')
       .then(response => {
          this.transactions = response.data;
       })
       .catch(error => {
          console.error('Error fetching transactions:', error);
       });
    },
    addBudgetItem(item) {
       apiClient.post('/budget', item)
       .then(() => {
          this.fetchBudgetItems();
       })
       .catch(error => {
           console.error('Error adding budget item:', error);
       });
    },
    removeBudgetItem(id) {
      apiClient.delete(`/budget/${id}`)
      .then(() => {
         this.fetchBudgetItems();
            })
      .catch(error => {
         console.error('Error removing budget item:', error);
      });
    },
  },
  created() {
    this.fetchBudgetItems();
    this.fetchTransactions()
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

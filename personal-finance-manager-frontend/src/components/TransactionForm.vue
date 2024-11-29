<template>
  <div>
    <h2>Add Transaction</h2>
    <form @submit.prevent="submitTransaction" class="form">
      <div>
        <label for="type">Type:</label>
        <select v-model="transaction.type" id="type">
          <option>Income</option>
          <option>Expense</option>
        </select>
      </div>
      <div>
        <label for="amount">Amount:</label>
        <input class="form-control" type="number" v-model="transaction.amount" id="amount" required>
      </div>
      <div>
        <label for="category">Category:</label>
        <input class="form-control" type="text" v-model="transaction.category" id="category" required>
      </div>
      <div>
        <label for="description">Description:</label>
        <input class="form-control" type="text" v-model="transaction.description" id="description">
      </div>
      <button type="submit" class="button">Add Transaction</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      transaction: {
        type: 'Income',
        amount: 0,
        category: '',
        description: ''
      }
    };
  },
  methods: {
    submitTransaction() {
      axios.post('http://localhost:8080/api/transactions', this.transaction)
        .then(() => {
          this.$emit('transaction-added');
          this.transaction = {
            type: 'Income',
            amount: 0,
            category: '',
            description: ''
          };
        })
        .catch(error => {
          console.error('There was an error adding the transaction!', error);
        });
    }
  }
};
</script>

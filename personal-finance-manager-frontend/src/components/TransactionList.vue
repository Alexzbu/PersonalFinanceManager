<template>
  <div>
    <h2>Transactions</h2>
    <ul class="transaction-list">
      <li v-for="transaction in transactions" :key="transaction.id" class="transaction-item">
        {{ transaction.type }} - {{ transaction.amount }} - {{ transaction.category }}
        <button @click="deleteTransaction(transaction.id)">Delete</button>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      transactions: []
    };
  },
  methods: {
    fetchTransactions() {
      axios.get('http://localhost:8080/api/transactions')
        .then(response => {
          this.transactions = response.data;
        })
        .catch(error => {
          console.error('There was an error fetching the transactions!', error);
        });
    },
    deleteTransaction(id) {
      axios.delete(`http://localhost:8080/api/transactions/${id}`)
        .then(() => {
          this.fetchTransactions();
        })
        .catch(error => {
          console.error('There was an error deleting the transaction!', error);
        });
    }
  },
  created() {
    this.fetchTransactions();
  }
};
</script>

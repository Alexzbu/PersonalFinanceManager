<template>
  <div class="container">
    <h1>Transactions</h1>
    <AddTransaction @add-transaction="addTransaction"/>
    <TransactionList :transactions="transactions" @fetch-transactions="fetchTransactions" @remove-transaction-item="removeTransactionItem"/>
  </div>
</template>

<script>
import AddTransaction from '@/components/AddTransaction.vue';
import TransactionList from '@/components/TransactionList.vue';
import apiClient from '@/api/index.js';

export default {
  name: 'TransactionsView',
  components: {
    AddTransaction,
    TransactionList
  },
  data() {
    return {
      transactions: []
    };
  },
  methods: {
    addTransaction(transaction) {
      apiClient.post('/transactions', transaction)
        .then(() => {
          this.fetchTransactions();
        })
        .catch(error => {
          console.error('Error adding transaction:', error);
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
    removeTransactionItem(id){
          apiClient.delete(`/transactions/${id}`)
            .then(() => {
              this.fetchTransactions();
             })
            .catch(error => {
             console.error('Error removing budget item:', error);
             });
        }
  },
  created() {
    this.fetchTransactions();
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
</style>

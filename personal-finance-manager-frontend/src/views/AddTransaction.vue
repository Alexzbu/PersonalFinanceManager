<template>
  <div class="container">
    <h1>Add Transaction</h1>
    <TransactionForm @transaction-added="fetchTransactions" class="form-control" />
  </div>
</template>

<script>
import TransactionForm from '@/components/TransactionForm.vue';

export default {
  name: 'AddTransaction',
  components: {
    TransactionForm
  },
  methods: {
    fetchTransactions() {
      this.$refs.transactionList.fetchTransactions();
    }
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

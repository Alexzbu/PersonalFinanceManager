<template>
   <div class="container">
      <h1>Transactions</h1>
      <TransactionForm @transaction-added="fetchTransactions" class="form-control" />
      <TransactionList ref="transactionList" />
      <BudgetPlanner />
    </div>
</template>

<script>
import TransactionForm from '@/components/TransactionForm.vue';
import TransactionList from '@/components/TransactionList.vue';
import BudgetPlanner from '@/components/BudgetPlanner.vue';

export default {
  name: 'TransactionsView',
  components: {
    TransactionForm,
    TransactionList,
    BudgetPlanner
  },
  methods: {
    fetchTransactions() {
      this.$refs.transactionList.fetchTransactions();
    }
  }
};
</script>

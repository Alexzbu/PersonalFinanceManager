<template>
  <div class="container">
    <h1>Transaction List</h1>
    <TransactionListComponent />
  </div>
</template>

<script>
import TransactionListComponent from '@/components/TransactionList.vue';

export default {
  name: 'TransactionList',
  components: {
    TransactionListComponent
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

<template>
  <div class="container">
    <h1>Transaction List</h1>
    <ul class="transaction-list">
      <li v-for="transaction in transactions" :key="transaction.id" class="transaction-item">
        {{ transaction.description }} - {{ transaction.amount }}
        <button @click="$emit('remove-transaction-item', transaction.id)" class="button-remove">Remove</button>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'TransactionList',
  props: ['transactions'],
  created() {
    this.$emit('fetch-transactions');
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

.transaction-list {
  list-style-type: none;
  padding: 0;
}

.transaction-item {
  display: flex;
    justify-content: space-between;
    padding: 10px;
    border-bottom: 1px solid #ccc;
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
</style>

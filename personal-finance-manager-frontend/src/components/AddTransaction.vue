<template>
  <div class="container">
    <h1>Add Transaction</h1>
    <form @submit.prevent="submitTransaction" class="form-control">
      <input
        type="text"
        v-model="newTransaction.description"
        placeholder="Description"
        class="form-control"
      />
      <input
        type="number"
        v-model="newTransaction.amount"
        placeholder="Amount"
        class="form-control"
      />
      <button type="submit" class="button">Add Transaction</button>
    </form>
  </div>
</template>

<script>
export default {
  name: 'AddTransaction',
  data() {
    return {
      newTransaction: {
        description: '',
        amount: null
      }
    };
  },
  methods: {
    submitTransaction() {
      if (this.newTransaction.description && this.newTransaction.amount) {
        this.$emit('add-transaction', { ...this.newTransaction });
        this.newTransaction.description = '';
        this.newTransaction.amount = null;
      }
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
</style>

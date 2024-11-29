<template>
  <div class="container">
    <h1>Budget Planner</h1>
    <BudgetPlannerComponent />
  </div>
</template>

<script>
import BudgetPlannerComponent from '@/components/BudgetPlanner.vue';

export default {
  name: 'BudgetPlanner',
  components: {
    BudgetPlannerComponent
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

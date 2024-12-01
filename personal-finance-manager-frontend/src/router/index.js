import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/views/Home.vue';
import TransactionsView from '@/views/Transactions.vue';
import BudgetPlanner from '@/views/BudgetPlanner.vue';

const routes = [
  { path: '/', name: 'Home', component: HomeView },
  { path: '/transactions', name: 'Transactions', component: TransactionsView },
  { path: '/budget', name: 'BudgetPlanner', component: BudgetPlanner }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;

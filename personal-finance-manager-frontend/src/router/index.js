import { createRouter, createWebHistory } from 'vue-router';
import AddTransaction from '@/views/AddTransaction.vue';
import BudgetPlanner from '@/views/BudgetPlanner.vue';
import TransactionList from '@/views/TransactionList.vue';
import BudgetList from '@/views/BudgetList.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    redirect: '/add-transaction'
  },
  {
    path: '/add-transaction',
    name: 'AddTransaction',
    component: AddTransaction
  },
  {
    path: '/budget-planner',
    name: 'BudgetPlanner',
    component: BudgetPlanner
  },
  {
    path: '/transaction-list',
    name: 'TransactionList',
    component: TransactionList
  },
  {
    path: '/budget-list',
    name: 'BudgetList',
    component: BudgetList
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;

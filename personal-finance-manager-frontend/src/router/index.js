import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/views/Home.vue';
import TransactionsView from '@/views/Transactions.vue';
import BudgetPlanner from '@/views/BudgetPlanner.vue';
import RegisterView from '@/views/Register.vue';
import LoginView from '@/views/Login.vue';

const routes = [
  { path: '/', name: 'Home', component: HomeView },
  { path: '/register', name: 'Register', component: RegisterView },
  { path: '/login', name: 'Login', component: LoginView },
  { path: '/transactions', name: 'Transactions', component: TransactionsView, meta: { requiresAuth: true }},
  { path: '/budget', name: 'BudgetPlanner', component: BudgetPlanner, meta: { requiresAuth: true }},

];

const router = createRouter({
  history: createWebHistory(),
  routes
});

router.beforeEach((to, from, next) => {
  const loggedIn = localStorage.getItem('jwt');

  if (to.matched.some(record => record.meta.requiresAuth) && !loggedIn) {
    next('/login');
  } else {
    next();
  }
});

export default router;

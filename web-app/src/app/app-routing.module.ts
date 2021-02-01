import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientsListComponent } from './components/clients-list/clients-list.component';
import { HomeComponent } from './components/home/home.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { TransactionsComponent } from './components/transactions/transactions.component';



const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'clients-list', component: ClientsListComponent },
  { path: 'client-transaction', component: TransactionsComponent },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

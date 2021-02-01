import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TransactionsComponent } from './components/transactions/transactions.component';
import { ClientsListComponent } from './components/clients-list/clients-list.component';
import { ClientComponent } from './components/client/client.component';
import { SearchTransactionsComponent } from './components/search-transactions/search-transactions.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './components/home/home.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { HttpClientModule } from '@angular/common/http';
import { AddClientComponent } from './components/add-client/add-client.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    TransactionsComponent,
    ClientsListComponent,
    ClientComponent,
    SearchTransactionsComponent,
    HomeComponent,
    NotFoundComponent,
    AddClientComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

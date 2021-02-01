import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { ClientApiEndpoints } from '../enum/client-endpoints.enum';
import { TransactionApiEndpoints } from '../enum/transaction-endpoints.enum';
import { Client } from '../models/client.model';
import { Transaction } from '../models/transaction.model';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  constructor(private http: HttpClient) { }

  private environment = "http://localhost:8080";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })
  };

  getTransactionsList(id: string): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(this.environment + TransactionApiEndpoints.GET_ALL_TRANSACTIONS + id).pipe(
      tap(_ => _),
      catchError(
        error => {
          throw error;
        }
      )
    );
  }

  createTransaction(transaction: Transaction): Observable<Transaction[]> {
    return this.http.post<Transaction[]>(this.environment + TransactionApiEndpoints.CREATE_TRANSACTION, transaction).pipe(
      tap(_ => _),
      catchError(
        error => {
          throw error;
        }
      )
    );
  }

  deleteTransaction(id: string): Observable<any> {
    return this.http.delete<any>(this.environment + TransactionApiEndpoints.DELETE_TRANSACTION + id).pipe(
      tap(_ => _),
      catchError(
        error => {
          throw error;
        }
      )
    );
  }


}

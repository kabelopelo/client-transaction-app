import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { ClientApiEndpoints } from '../enum/client-endpoints.enum';
import { Client } from '../models/client.model';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }

  private environment = "http://localhost:8080";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })
  };

  getClientsList(): Observable<Client[]> {
    return this.http.get<Client[]>(this.environment + ClientApiEndpoints.GET_ALL_CLIENTS).pipe(
      tap(_ => _),
      catchError(
        error => {
          throw error;
        }
      )
    );
  }

  getClient(id: string): Observable<Client> {
    return this.http.get<Client>(this.environment + ClientApiEndpoints.GET_CLIENT + id).pipe(
      tap(_ => console.log('fetched client: ' + id)),
      catchError(
        error => {
          throw error;
        }
      )
    );
  }


  deleteClient(id: string): Observable<any> {
    return this.http.delete<any>(this.environment + ClientApiEndpoints.DELETE_CLIENT + id).pipe(
      tap(_ => console.log('deleted client: ' + id)),
      catchError(
        error => {
          throw error;
        }
      )
    );
  }


  updateClient(clientModel: Client): Observable<Client> {
    return this.http.put<Client>(this.environment + ClientApiEndpoints.UPDATE_CLIENT, clientModel).pipe(
      tap(_ => console.log('saved client: ' + _._id)),
      catchError(
        error => {
          throw error;
        }
      )
    );
  }

  createClient(clientModel: Client): Observable<Client> {
    return this.http.post<Client>(this.environment + ClientApiEndpoints.CREATE_CLIENT, clientModel).pipe(
      tap(_ => console.log('Created client: ' + _._id)),
      catchError(
        error => {
          throw error;
        }
      )
    );
  }



}

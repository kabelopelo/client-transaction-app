import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EditStateService {
  private isEditSource = new BehaviorSubject<boolean>(false);
  isEdit = this.isEditSource.asObservable()

  private clientIdSource = new BehaviorSubject<string>(null);
  clientId = this.clientIdSource.asObservable()
  
  constructor() { }
  
  changeEditState(isEdit: boolean) {
    this.isEditSource.next(isEdit);
  }

  changeClientIdState(id: string) {
    this.clientIdSource.next(id);
  }


  
}

import { AfterViewInit, Component, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import { EditStateService } from 'src/app/services/edit-state.service';
import { ClientComponent } from '../client/client.component';

@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})

export class AddClientComponent implements OnInit {
  @Output() clearFields = new EventEmitter<void>();


  isEdit: boolean;

  constructor(private editState: EditStateService) { }

  ngOnInit() {
    this.editState.isEdit.subscribe(result => {
      this.isEdit = result; // set's isEdit to the default observable value
    });
  }

  addClient(): void {
    this.isEdit = true;
    this.updateEditState();
    this.sendClearClients();
  }

  sendClearClients() {
    this.clearFields.emit(); // emit clear client details on add client
  }

  updateEditState() {
    this.editState.changeEditState(this.isEdit);
  }

}

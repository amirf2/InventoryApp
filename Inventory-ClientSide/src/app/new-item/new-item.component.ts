import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-new-item',
  templateUrl: './new-item.component.html',
  styleUrls: ['./new-item.component.css']
})

export class NewItemComponent implements OnInit {

  newItemForm: FormGroup;
  SERVER_URL = 'http://localhost:8080/items';
  options = { headers: new HttpHeaders().set('Content-Type', 'application/json') };

  constructor(private route: ActivatedRoute, private router: Router, private formBuilder: FormBuilder, private httpClient: HttpClient) {
  }

  ngOnInit(): void {
    this.newItemForm = this.formBuilder.group({
      idNumber: '',
      name: '',
      amount: '',
      inventoryCode: ''
    });
  }

  onSubmit() {
    const formData = new FormData();
    formData.append('idNumber', this.newItemForm.get('idNumber').value);
    formData.append('name', this.newItemForm.get('name').value);
    formData.append('amount', this.newItemForm.get('amount').value);
    formData.append('inventoryCode', this.newItemForm.get('inventoryCode').value);
    const newItem = {
      number: this.newItemForm.get('idNumber').value,
      name: this.newItemForm.get('name').value,
      amount: this.newItemForm.get('amount').value,
      inventoryCode: this.newItemForm.get('inventoryCode').value,
    }
    this.httpClient.post<any>(`${this.SERVER_URL}`, JSON.stringify(newItem), this.options).subscribe(
      (succ) => this.router.navigate([`/items/`]),
      (err) => this.router.navigate([`/items/`])
    );
  }

}



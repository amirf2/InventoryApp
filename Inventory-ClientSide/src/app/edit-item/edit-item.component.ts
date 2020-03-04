import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-item',
  templateUrl: './edit-item.component.html',
  styleUrls: ['./edit-item.component.css']
})
export class EditItemComponent implements OnInit {

  id: string;
  editForm: FormGroup;
  SERVER_URL = 'http://localhost:8080/items/';

  constructor(private route: ActivatedRoute, private router: Router, private formBuilder: FormBuilder, private httpClient: HttpClient) {
    this.id = this.route.snapshot.paramMap.get('id');
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group({
      depositAmount: '',
      withdrawalAmount: ''
    });
  }

  onSubmitDeposit() {
    console.log(`hey`);
    const formData = new FormData();
    formData.append('amount', this.editForm.get('depositAmount').value);
    this.httpClient.put<any>(`${this.SERVER_URL}${this.id}/deposit`, formData).subscribe(
      () => this.router.navigate([`/items/${this.id}`])
    );
  }

  onSubmitWithdrawal() {
    console.log(`${this.SERVER_URL}${this.id}/withdrawal`);
    const formData = new FormData();
    formData.append('amount', this.editForm.get('withdrawalAmount').value);
    this.httpClient.put<any>(`${this.SERVER_URL}${this.id}/withdrawal`, formData).subscribe(
      (succ) => this.router.navigate([`/items/${this.id}`]),
      (err) => this.router.navigate([`/items/${this.id}`])
    );
  }

}



import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-all-items',
  templateUrl: './list-all-items.component.html',
  styleUrls: ['./list-all-items.component.css']
})
export class ListAllItemsComponent implements OnInit {

  items = [];

  constructor() { }

  ngOnInit(): void {
    fetch('http://localhost:8080/items', {
      method: 'GET'
    }).then((response) => {
      return response.json();
    }).then((myJson) => {
      this.items = myJson;
    });
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-show-item',
  templateUrl: './show-item.component.html',
  styleUrls: ['./show-item.component.css']
})
export class ShowItemComponent implements OnInit {

  item = {};
  id: string;

  constructor(private route: ActivatedRoute) {
    this.id = this.route.snapshot.paramMap.get('id');
  }

  ngOnInit(): void {
    fetch(`http://localhost:8080/items/${this.id}`, {
      method: 'GET'
    }).then((response) => {
      return response.json();
    }).then((myJson) => {
      this.item = myJson;
    });
  }

}

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import {NewItemComponent} from './new-item/new-item.component';
import {EditItemComponent} from './edit-item/edit-item.component';
import {ShowItemComponent} from './show-item/show-item.component';
import {ListAllItemsComponent} from './list-all-items/list-all-items.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

const routes: Routes = [
  {path: '', redirectTo: '/items', pathMatch: 'full'},
  {path: 'items/new', component: NewItemComponent},
  {path: 'items/:id/edit', component: EditItemComponent},
  {path: 'items/:id', component: ShowItemComponent},
  {path: 'items', component: ListAllItemsComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
    ReactiveFormsModule,
    HttpClientModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewItemComponent } from './new-item/new-item.component';
import { EditItemComponent } from './edit-item/edit-item.component';
import { ShowItemComponent } from './show-item/show-item.component';
import { ListAllItemsComponent } from './list-all-items/list-all-items.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    NewItemComponent,
    EditItemComponent,
    ShowItemComponent,
    ListAllItemsComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

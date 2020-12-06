import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';

import { GithubComponent } from './github.component';
import { InputModule } from 'src/app/components/input/input.module';
import { ButtonModule } from 'src/app/components/button/button.module';
import { TableModule } from 'src/app/components/table/table.module';
import { ModalModule } from 'src/app/components/modal/modal.module';

describe('GithubComponent', () => {
  let component: GithubComponent;
  let fixture: ComponentFixture<GithubComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GithubComponent],
      imports: [
        HttpClientTestingModule,
        FormsModule,
        InputModule,
        ButtonModule,
        TableModule,
        ModalModule
      ]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GithubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('ngOnInit should create cols', () => {
    component.ngOnInit();

    expect(component.userCols).toHaveSize(6);
    expect(component.reposCols).toHaveSize(3);
    expect(component.starredCols).toHaveSize(4);
  });
});

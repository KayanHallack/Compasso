import { RouterTestingModule } from '@angular/router/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GithubUserDetailsComponent } from './github-user-details.component';
import { DatePipe } from '@angular/common';
import { InputModule } from 'src/app/components/input/input.module';

describe('GithubUserDetailsComponent', () => {
  let component: GithubUserDetailsComponent;
  let fixture: ComponentFixture<GithubUserDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GithubUserDetailsComponent],
      imports: [RouterTestingModule, InputModule],
      providers: [DatePipe],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GithubUserDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

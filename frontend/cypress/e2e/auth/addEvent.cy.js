/// <reference types="cypress" />

describe('Add Event tests', () => {

  beforeEach(() => {
    // Login as organizer/owner
    cy.visit('http://localhost:3000/login');
    cy.get('input').eq(0).type('matejadjuric88@gmail.com', { force: true });
    cy.get('input').eq(1).type('test', { force: true });
    cy.contains('button', 'Login').click({ force: true });

    cy.url().should('eq', 'http://localhost:3000/');

    // Direct navigation to add event form
    cy.visit('http://localhost:3000/addogodekvklub');

    cy.url().should('include', '/addogodekvklub');
  });

  it('TC-DOGODEK-001: Valid event creation', () => {
    const randomName = "Event" + Date.now();

    cy.get('#eventDate').type('2025-12-25T21:00', { force: true });
    cy.get('#partyName').type(randomName, { force: true });
    cy.get('#partyDescription').type('Mega zabava!', { force: true });
    cy.get('#ticketPrice').type('15', { force: true });
    cy.get('#ticketCount').type('100', { force: true });
    cy.get('#tableCount').type('20', { force: true });

    cy.contains('button', 'Add Party').click({ force: true });

    cy.url().should('eq', 'http://localhost:3000/');
  });

  it('TC-DOGODEK-002: Missing required field triggers alert', () => {
    cy.get('#eventDate').type('2025-10-01T20:00', { force: true });
    cy.get('#partyName').type('Test Event', { force: true });
    // price intentionally missing ❌

    cy.on('window:alert', (msg) => {
      expect(msg).to.contains('All fields are required!');
    });

    cy.contains('button', 'Add Party').click({ force: true });
  });

  it('TC-DOGODEK-003: Events list is displayed', () => {
    cy.visit('http://localhost:3000/dogodki');
    
    cy.get('.event-card', { timeout: 10000 }).should('exist');
    cy.get('.event-card').its('length').should('be.gte', 1);
  });

});

Cypress.on('uncaught:exception', () => false);

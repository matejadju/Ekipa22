describe('Club registration tests', () => {

  beforeEach(() => {
  cy.visit('http://localhost:3000/login');
  cy.get('input').eq(0).type('matejadjuric88@gmail.com', { force: true });
  cy.get('input').eq(1).type('test', { force: true });
  cy.contains('button', 'Login').click({ force: true });

  cy.url().should('eq', 'http://localhost:3000/'); // ⬅ sačekaj HOME

  cy.visit('http://localhost:3000/rklub'); // tek onda idi dalje

  cy.url().should('include', '/rklub'); // ⬅ potvrda da smo tu
});


  it('TC-KLUB-001: Valid club registration', () => {
    cy.get('#clubName').type('Cyber Club', { force: true });
    cy.get('#address').type('Tesla 7', { force: true });
    cy.get('#phoneNumber').type('060112233', { force: true });
    cy.get('#pib').type('12345678', { force: true });

    cy.contains('button', 'Register your club').click({ force: true });

    cy.url().should('eq', 'http://localhost:3000/');
  });

  it('TC-KLUB-002: Missing required field', () => {
    cy.get('#clubName').type('Cyber Club', { force: true });
    cy.get('#phoneNumber').type('060112233', { force: true });
    cy.get('#pib').type('12345678', { force: true });

    cy.on('window:alert', (txt) => {
    expect(txt).to.contains('All fields are required!');
    });


    cy.contains('button', 'Register your club').click({ force: true });
  });

});

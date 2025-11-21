describe('Login tests', () => {

  beforeEach(() => {
    cy.visit('http://localhost:3000/login');
  });

  it('TC-LOGIN-001: Valid login', () => {
    cy.get('input').eq(0).type('mateja@gmail.com', { force: true });
    cy.get('input').eq(1).type('test', { force: true });
    cy.contains('button', 'Login').click({ force: true });

    cy.url().should('eq', 'http://localhost:3000/');
  });

  it('TC-LOGIN-002: Invalid password', () => {
    cy.get('input').eq(0).type('mateja@gmail.com', { force: true });
    cy.get('input').eq(1).type('pogresno', { force: true });
    

    // cy.wait(500);

    cy.on('window:alert', (txt) => {
      expect(txt).to.contains('Invalid credentials');
    });
    cy.contains('button', 'Login').click({ force: true });
  });

});

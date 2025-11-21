describe('Registration tests', () => {

  beforeEach(() => {
    cy.visit('http://localhost:3000/register');
  });

  it('TC-REG-001: Valid registration', () => {
    const randomEmail = `test${Date.now()}@gmail.com`;

    cy.get('#name').type('Mateja', { force: true });
    cy.get('#surname').type('Djuric', { force: true });
    cy.get('#email').type(randomEmail, { force: true });
    cy.get('#password').type('test123', { force: true });
    cy.get('#phoneNumber').type('0651234567', { force: true });
    cy.get('#taxNumber').type('12345678', { force: true });
    cy.get('#emso').type('12345678', { force: true });
    cy.get('#type').click({ force: true });
    cy.contains('li', 'User').click({ force: true });

    cy.contains('button', 'Register').click({ force: true });

    cy.url().should('include', '/login');
  });

  it('TC-REG-002: Email already exists', () => {
    cy.get('#name').type('Mateja', { force: true });
    cy.get('#surname').type('Djuric', { force: true });
    cy.get('#email').type('mateja@gmail.com', { force: true });
    cy.get('#password').type('test123', { force: true });
    cy.get('#phoneNumber').type('0651234567', { force: true });
    cy.get('#taxNumber').type('12345678', { force: true });
    cy.get('#emso').type('1234567890123', { force: true });

    cy.get('#type').click({ force: true });
    cy.contains('li', 'User').click({ force: true });

    cy.on('window:alert', (txt) => {
      expect(txt).to.contains('User already exists');
    });

    cy.contains('button', 'Register').click({ force: true });
  });

});

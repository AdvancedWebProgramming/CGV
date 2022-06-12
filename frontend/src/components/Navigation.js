import { Container, Nav, Navbar } from 'react-bootstrap'

const Navigation = () =>{
    return(
        <Navbar bg="primary" variant="dark">
            <Container>
            <Navbar.Brand href="/">Home</Navbar.Brand>
            <Nav className="me-auto">
            <Nav.Link href="/login">로그인</Nav.Link>
            <Nav.Link href="/signup">회원가입</Nav.Link>
            <Nav.Link href="/ratingboard">리뷰</Nav.Link>
            </Nav>
            </Container>
        </Navbar>
    )
}

export default Navigation;
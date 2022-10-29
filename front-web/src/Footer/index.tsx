import "./styles.css";

import {ReactComponent as Youtube} from './youtube.svg';
import {ReactComponent as Instagram} from './instagram.svg';
import {ReactComponent as Linkedin} from './linkedin.svg';

function Footer(){
    return(
        <footer className="main-footer">
          App desenvolvido por Suleimane Manuel Nanque durante treinamento da Semana DevSuperior
          <div className="footer-icons">
             <a href="youtube" target="_new">
               <Youtube />
             </a>
             <a href="linkedin" target="_new">
               <Instagram />
             </a>
             <a href="instagram" target="_new">
               <Linkedin />
             </a>
          </div>
        </footer>
    );
}

export default Footer;
import 'document-register-element';
import { boot } from "../../../target/scala-2.12/app-opt.js";
//import { boot } from "biread-scala/target/scala-2.12/app-fastopt.js";
import "src/main/scss/all.scss";
import 'src/main/scss/bootstrap.scss';
//import 'src/main/scss/bootstrap-grid.min.css';
//import 'src/main/scss/bootstrap-reboot.min.css';

boot();
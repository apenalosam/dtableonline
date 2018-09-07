  
  import './node_modules/@polymer/iron-icon/iron-icon.js';
  import {PolymerElement, html} from './node_modules/@polymer/polymer/polymer-element.js';

  class IconToggle extends PolymerElement {
    static get template() {
      return html`
          <style>
            :host {
              display: inline-block;
            }
            iron-icon {
              fill: var(--icon-toggle-color, rgba(0,0,0,0));
              stroke: var(--icon-toggle-outline-color, currentcolor);
            }
            :host([pressed]) iron-icon {
              fill: var(--icon-toggle-pressed-color, currentcolor);
      
            }      
          </style>
          <iron-icon icon="[[toggleIcon]]"></iron-icon>
      `;
    }

    static get properties(){
      return{
        toggleIcon: {
          type: String
        },
        pressed: {
          type: Boolean,
          value: false,
          notify: true,
          reflectToAttribute: true
        }
      };
    }

    toggle() {
      this.pressed = !this.pressed;
    }

    constructor() {
      super();
      this.addEventListener('click', this.toggle.bind(this));
    }

  }

  customElements.define('icon-toggle', IconToggle);

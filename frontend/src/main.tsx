import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './main.css'
import { PayPalScriptProvider } from '@paypal/react-paypal-js'
import { PAYPAL_ID } from './functions/ApiConst.ts'

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <PayPalScriptProvider options={{
      "clientId": PAYPAL_ID,
      }}>

      <App />
    </PayPalScriptProvider>
  </React.StrictMode>,
)

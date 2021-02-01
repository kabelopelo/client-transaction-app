
export class Transaction {

    _id: string;
    _clientId: string;
    transactionsAmount: number;
    transactionDate: any;

    constructor() {
        this._id = null;
        this._clientId = null;
        this.transactionsAmount = null
        this.transactionDate = null;
    }
}
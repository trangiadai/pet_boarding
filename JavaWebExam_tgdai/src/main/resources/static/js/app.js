const API_BASE_URL = 'http://localhost:8085/api';

const ICONS = {
    paw: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="7" cy="9" r="2"/><circle cx="12" cy="6" r="2"/><circle cx="17" cy="9" r="2"/><path d="M7.5 13.5c-1.8 0-3 1.6-3 3.3 0 1.6 1.2 2.7 2.9 2.7 1 0 1.7-.4 2.6-.4.9 0 1.6.4 2.6.4.9 0 1.6-.4 2.6-.4.9 0 1.6.4 2.6.4 1.7 0 2.9-1.1 2.9-2.7 0-1.7-1.2-3.3-3-3.3-2 0-2.6 1.3-5.1 1.3s-3.1-1.3-5.1-1.3z"/></svg>`,
    chart: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><line x1="4" y1="20" x2="20" y2="20"/><rect x="6" y="12" width="3" height="8"/><rect x="13" y="7" width="3" height="13"/><rect x="17" y="4" width="3" height="16"/></svg>`,
    person: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="12" cy="8" r="3.4"/><path d="M5 20c0-3.6 3.1-6.4 7-6.4s7 2.8 7 6.4"/></svg>`,
    paws2: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="6" cy="7" r="1.6"/><circle cx="10" cy="5" r="1.6"/><circle cx="9" cy="12" r="2.6"/><circle cx="17" cy="15" r="1.6"/><circle cx="21" cy="13" r="1.6"/><circle cx="18" cy="20" r="2.6"/></svg>`,
    clipboard: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><rect x="5" y="4" width="14" height="17" rx="2"/><rect x="9" y="2.3" width="6" height="3.4" rx="1"/><line x1="8.5" y1="11" x2="15.5" y2="11"/><line x1="8.5" y1="15" x2="13" y2="15"/></svg>`,
    trending: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><polyline points="3,17 9,11 13,15 21,6"/><polyline points="15,6 21,6 21,12"/></svg>`,
    scroll: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M6 4h11a2 2 0 0 1 2 2v13a1.5 1.5 0 0 1-3 0V6a2 2 0 0 0-2-2H6a2 2 0 0 0-2 2v0a2 2 0 0 0 2 2h1"/><line x1="8" y1="10" x2="15" y2="10"/><line x1="8" y1="13.5" x2="13" y2="13.5"/></svg>`,
    search: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="11" cy="11" r="7"/><line x1="21" y1="21" x2="16.2" y2="16.2"/></svg>`,
    plus: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.4" stroke-linecap="round"><line x1="12" y1="5" x2="12" y2="19"/><line x1="5" y1="12" x2="19" y2="12"/></svg>`,
    x: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.2" stroke-linecap="round"><line x1="6" y1="6" x2="18" y2="18"/><line x1="18" y1="6" x2="6" y2="18"/></svg>`,
    eye: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M2 12s3.6-7 10-7 10 7 10 7-3.6 7-10 7-10-7-10-7z"/><circle cx="12" cy="12" r="3"/></svg>`,
    pencil: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M4 20l.9-4L17 4.9a1.7 1.7 0 0 1 2.4 0l-.3-.3a1.7 1.7 0 0 1 0 2.4L8 18.1z"/><path d="M14.5 6.5l3 3"/></svg>`,
    trash: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><line x1="4" y1="7" x2="20" y2="7"/><path d="M6 7l1 13a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2l1-13"/><path d="M9 7V4.6A1.6 1.6 0 0 1 10.6 3h2.8A1.6 1.6 0 0 1 15 4.6V7"/></svg>`,
    save: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M5 3h11l3 3v15H5z"/><path d="M8 3v6h8V3"/><path d="M8 21v-7h8v7"/></svg>`,
    check: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.4" stroke-linecap="round" stroke-linejoin="round"><polyline points="20,6 9,17 4,12"/></svg>`,
    pin: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M12 21s7-6.3 7-11.5A7 7 0 0 0 5 9.5C5 14.7 12 21 12 21z"/><circle cx="12" cy="9.5" r="2.3"/></svg>`,
    clock: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="12" cy="12" r="9"/><polyline points="12,7 12,12 16,14"/></svg>`,
    note: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M4 4h13l3 3v13H4z"/><line x1="8" y1="10" x2="16" y2="10"/><line x1="8" y1="14" x2="13" y2="14"/></svg>`,
    money: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><rect x="2.5" y="6" width="19" height="12" rx="2"/><circle cx="12" cy="12" r="3"/><line x1="6" y1="9" x2="6" y2="9.01"/><line x1="18" y1="15" x2="18" y2="15.01"/></svg>`,
    calendar: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><rect x="3.5" y="5" width="17" height="16" rx="2"/><line x1="16" y1="3" x2="16" y2="7"/><line x1="8" y1="3" x2="8" y2="7"/><line x1="3.5" y1="10" x2="20.5" y2="10"/></svg>`,
    arrowLeft: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.2" stroke-linecap="round" stroke-linejoin="round"><polyline points="15,18 9,12 15,6"/></svg>`,
    arrowRight: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.2" stroke-linecap="round" stroke-linejoin="round"><polyline points="9,18 15,12 9,6"/></svg>`,
    star: `<svg viewBox="0 0 24 24" fill="currentColor" stroke="none"><path d="M12 2.5l2.9 6 6.6.9-4.8 4.6 1.2 6.5L12 17.4l-5.9 3.1 1.2-6.5-4.8-4.6 6.6-.9z"/></svg>`,
    lock: `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><rect x="5" y="10.5" width="14" height="9.5" rx="2"/><path d="M8 10.5V7.5a4 4 0 0 1 8 0v3"/></svg>`,
};
function petEmoji(type) { return { DOG: '🐶', CAT: '🐱', BIRD: '🐦', RABBIT: '🐰', OTHER: '🐾' }[type] || '🐾'; }
const PET_TYPES = ['DOG', 'CAT', 'BIRD', 'RABBIT', 'OTHER'];

const $ = (sel, root = document) => root.querySelector(sel);
const $$ = (sel, root = document) => Array.from(root.querySelectorAll(sel));
function escapeHtml(str) { return String(str ?? '').replace(/[&<>"']/g, c => ({ '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;' }[c])); }
function debounce(fn, ms = 280) { let t; return (...a) => { clearTimeout(t); t = setTimeout(() => fn(...a), ms); }; }

function fmtVND(n) { if (n === null || n === undefined) return '—'; return Math.round(n).toLocaleString('vi-VN') + 'đ'; }
function fmtDate(iso) {
    if (!iso) return '—';
    const d = new Date(iso.slice(0, 10) + 'T00:00:00');
    if (isNaN(d)) return '—';
    return `${String(d.getDate()).padStart(2, '0')}/${String(d.getMonth() + 1).padStart(2, '0')}/${d.getFullYear()}`;
}
function fmtDateTime(iso) {
    if (!iso) return '—';
    const [datePart, timePart = ''] = iso.split('T');
    return `${fmtDate(datePart)}${timePart ? ' ' + timePart.slice(0, 5) : ''}`;
}
function todayISO() { const d = new Date(); return `${d.getFullYear()}-${String(d.getMonth() + 1).padStart(2, '0')}-${String(d.getDate()).padStart(2, '0')}`; }
function addDaysISO(iso, days) { const d = new Date(iso + 'T00:00:00'); d.setDate(d.getDate() + Number(days || 0)); return `${d.getFullYear()}-${String(d.getMonth() + 1).padStart(2, '0')}-${String(d.getDate()).padStart(2, '0')}`; }
function daysBetween(startISO, endISO) {
    if (!startISO || !endISO) return NaN;
    const a = new Date(String(startISO).slice(0, 10) + 'T00:00:00');
    const b = new Date(String(endISO).slice(0, 10) + 'T00:00:00');
    if (isNaN(a) || isNaN(b)) return NaN;
    return Math.max(0, Math.round((b - a) / 86400000));
}

function stayDays(checkInISO, checkOutISO) {
    const d = daysBetween(checkInISO, checkOutISO);
    return isNaN(d) ? null : Math.max(1, d);
}

function toast(msg, type = '') {
    const root = $('#toast-root');
    const el = document.createElement('div');
    el.className = 'toast' + (type ? ' ' + type : '');
    el.innerHTML = `${type === 'error' ? ICONS.x : ICONS.check}<span>${escapeHtml(msg)}</span>`;
    root.appendChild(el);
    setTimeout(() => { el.style.opacity = '0'; el.style.transition = 'opacity .25s'; setTimeout(() => el.remove(), 250); }, 3200);
}

function openModal(id) { const ov = document.getElementById(id); if (ov) ov.classList.add('is-open'); }
function closeModal(id) { const ov = document.getElementById(id); if (ov) ov.classList.remove('is-open'); }
document.addEventListener('click', (e) => { if (e.target.classList && e.target.classList.contains('modal-overlay')) e.target.classList.remove('is-open'); });
document.addEventListener('keydown', (e) => { if (e.key === 'Escape') $$('.modal-overlay.is-open').forEach(ov => ov.classList.remove('is-open')); });

function boardingBadge(status) { return status === 'BOARDING' ? `<span class="badge badge-boarding">Đang gửi</span>` : `<span class="badge badge-returned">Đã trả</span>`; }
function petStatusBadge(status) { return status === 'BOARDING' ? `<span class="badge badge-boarding">Đang gửi</span>` : `<span class="badge badge-home">Ở nhà</span>`; }
function accountBadge(has) { return has ? `<span class="badge badge-yes">Có TK</span>` : `<span class="badge badge-no">Chưa có</span>`; }

function paginate(arr, page, pageSize) { const start = (page - 1) * pageSize; return arr.slice(start, start + pageSize); }
function renderPager(container, total, page, pageSize, onChange) {
    const pages = Math.max(1, Math.ceil(total / pageSize));
    if (pages <= 1) { container.innerHTML = ''; return; }
    let html = `<button data-p="${page - 1}" ${page === 1 ? 'disabled' : ''}>${ICONS.arrowLeft}</button>`;
    for (let i = 1;i <= pages;i++) {
        if (pages > 7 && i !== 1 && i !== pages && Math.abs(i - page) > 1) { if (i === 2 || i === pages - 1) html += `<span class="of">…</span>`; continue; }
        html += `<button data-p="${i}" class="${i === page ? 'is-active' : ''}">${i}</button>`;
    }
    html += `<span class="of">${page}/${pages}</span><button data-p="${page + 1}" ${page === pages ? 'disabled' : ''}>${ICONS.arrowRight}</button>`;
    container.innerHTML = html;
    $$('button', container).forEach(b => b.addEventListener('click', () => { const p = Number(b.dataset.p); if (p >= 1 && p <= pages) onChange(p); }));
}

const Store = {
    get(key, fallback) {
        try {
            const raw = localStorage.getItem('pawtrack:' + key);
            return raw != null ? JSON.parse(raw) : fallback;
        } catch (e) { return fallback; }
    },
    set(key, value) {
        try { localStorage.setItem('pawtrack:' + key, JSON.stringify(value)); } catch (e) { /* ignore */ }
    },
    remove(key) {
        try { localStorage.removeItem('pawtrack:' + key); } catch (e) { /* ignore */ }
    },
};

const Rules = {
    required: (v) => (v == null || String(v).trim() === '') ? 'Trường này là bắt buộc' : '',
    maxLen: (max) => (v) => (v && String(v).trim().length > max) ? `Tối đa ${max} ký tự` : '',
    minLen: (min) => (v) => (v && String(v).trim().length < min) ? `Tối thiểu ${min} ký tự` : '',
    select: (v) => (!v ? 'Vui lòng chọn một giá trị' : ''),
    phone: (v) => {
        const s = String(v || '').trim();
        if (!s) return 'Trường này là bắt buộc';
        if (!/^[0-9]+$/.test(s)) return 'Chỉ được chứa chữ số';
        if (s.length < 10 || s.length > 20) return 'Phải có từ 10 đến 20 chữ số';
        return '';
    },

    email: (v) => {
        const s = String(v || '').trim();
        if (!s) return '';
        if (s.length > 100) return 'Tối đa 100 ký tự';
        const re = /^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[^@\s]+\.[^@\s]+$/;
        return re.test(s) ? '' : 'Email không đúng định dạng (vd: ten@email.com)';
    },
    intRange: (min, max) => (v) => {
        if (v === '' || v == null) return 'Trường này là bắt buộc';
        const n = Number(v);
        if (!Number.isInteger(n)) return 'Phải là số nguyên';
        return (n >= min && n <= max) ? '' : `Phải trong khoảng ${min}–${max}`;
    },
    decimalRange: (min, max) => (v) => {
        if (v === '' || v == null) return 'Trường này là bắt buộc';
        const n = Number(v);
        if (isNaN(n)) return 'Giá trị không hợp lệ';
        return (n >= min && n <= max) ? '' : `Phải trong khoảng ${min}–${max}`;
    },
  
    positiveInt: (v) => {
        if (v === '' || v == null) return 'Trường này là bắt buộc';
        const n = Number(v);
        if (!Number.isInteger(n)) return 'Phải là số nguyên (không có phần thập phân)';
        return n > 0 ? '' : 'Phải là số dương (lớn hơn 0)';
    },
};

function setFieldError(input, errEl, msg) {
    input.classList.add('is-invalid');
    if (errEl) { errEl.textContent = msg; errEl.style.display = 'block'; }
}
function clearFieldError(input, errEl) {
    input.classList.remove('is-invalid');
    if (errEl) { errEl.textContent = ''; errEl.style.display = 'none'; }
}

function trackField(input, errEl, validate, onChange) {
    let touched = false;
    function run(forceShow) {
        const msg = validate(input.value);
        if ((touched || forceShow) && msg) setFieldError(input, errEl, msg);
        else clearFieldError(input, errEl);
        if (onChange) onChange();
        return !msg;
    }
    input.addEventListener('input', () => { touched = true; run(false); });
    input.addEventListener('blur', () => { touched = true; run(true); });
    input.addEventListener('change', () => { touched = true; run(true); });
    return {
        valid: () => !validate(input.value),
        reset: () => { touched = false; clearFieldError(input, errEl); },
    };
}

function bindForm(defs, submitBtn) {
    const controllers = new Map();
    function recompute() { submitBtn.disabled = ![...controllers.values()].every(c => c.valid()); }
    function setField(key, input, errEl, validate) {
        if (!input) { controllers.delete(key); recompute(); return; }
        controllers.set(key, trackField(input, errEl, validate, recompute));
        recompute();
    }
    defs.forEach(([key, input, errEl, validate]) => setField(key, input, errEl, validate));
    return {
        resetAll() { controllers.forEach(c => c.reset()); recompute(); },
        recompute,
        setField,
    };
}

class ApiError extends Error { constructor(message, status) { super(message); this.status = status; } }

function extractErrorMessage(data) {
    if (!data) return 'Đã xảy ra lỗi không xác định.';
    if (typeof data === 'string') return data;
    if (data.messages && typeof data.messages === 'object') return Object.values(data.messages).join('; ');
    if (data.message) return data.message;
    return 'Đã xảy ra lỗi không xác định.';
}

async function http(path, opts = {}) {
    const { method = 'GET', body } = opts;
    const headers = { 'Accept': 'application/json' };
    if (body !== undefined) headers['Content-Type'] = 'application/json';
    const authVal = Auth.authHeaderValue();
    if (authVal) headers['Authorization'] = authVal;

    let res;
    try {
        res = await fetch(API_BASE_URL + path, { method, headers, body: body !== undefined ? JSON.stringify(body) : undefined });
    } catch (networkErr) {
        throw new ApiError('Không thể kết nối đến máy chủ. Kiểm tra API_BASE_URL và cấu hình CORS trên backend.', 0);
    }

    const text = await res.text();
    let data = null;
    if (text) { try { data = JSON.parse(text); } catch (e) { data = text; } }

    if (res.status === 401) { Auth.logout(); throw new ApiError('Sai tên đăng nhập/mật khẩu, hoặc phiên đã hết hạn.', 401); }
    if (res.status === 403) throw new ApiError('Bạn không có quyền thực hiện thao tác này.', 403);
    if (!res.ok) throw new ApiError(extractErrorMessage(data), res.status);
    return data;
}

const SESSION_KEY = 'session';
const Auth = {
    state: null, 
    authHeaderValue() {
        if (!this.state) return null;
        return 'Basic ' + btoa(unescape(encodeURIComponent(this.state.username + ':' + this.state.password)));
    },
    async login(username, password) {
        this.state = { username, password, role: null };
        try {
            await http('/dashboard/overview');
            this.state.role = 'ROLE_ADMIN';
            Store.set(SESSION_KEY, this.state);
            return this.state;
        } catch (err) {
            if (err.status === 401 || err.status === 0) { this.state = null; throw err; }
        }
        try {
            await http('/pets/my-pets');
            this.state.role = 'ROLE_CUSTOMER';
            Store.set(SESSION_KEY, this.state);
            return this.state;
        } catch (err) {
            this.state = null;
            throw err.status ? err : new ApiError('Đăng nhập thất bại: không xác định được vai trò tài khoản.', 0);
        }
    },

    restoreSession() {
        const saved = Store.get(SESSION_KEY, null);
        if (saved && saved.username && saved.password && saved.role) {
            this.state = saved;
            return true;
        }
        return false;
    },
    isLoggedIn() { return !!(this.state && this.state.role); },
    logout() { this.state = null; Store.remove(SESSION_KEY); showLogin(); },
    initials(name) { return (name || '?').trim().slice(0, 2).toUpperCase(); },
};

const OwnersAPI = {
    list: () => http('/owners'),
    search: (keyword) => http(`/owners/search?keyword=${encodeURIComponent(keyword)}`),
    get: (id) => http(`/owners/${id}`),
    create: (data) => http('/owners', { method: 'POST', body: data }),
    update: (id, data) => http(`/owners/${id}`, { method: 'PUT', body: data }),
    remove: (id) => http(`/owners/${id}`, { method: 'DELETE' }),
};
const UsersAPI = {
    createAccount: (data) => http('/users', { method: 'POST', body: data }),
};
const PetsAPI = {
    list: () => http('/pets'),
    get: (id) => http(`/pets/${id}`),
    create: (data) => http('/pets', { method: 'POST', body: data }),
    update: (id, data) => http(`/pets/${id}`, { method: 'PUT', body: data }),
    remove: (id) => http(`/pets/${id}`, { method: 'DELETE' }),
    myPets: () => http('/pets/my-pets'),
    filterByTypes: (types) => http('/pets/filter' + (types && types.length ? '?' + types.map(t => 'rawTypes=' + encodeURIComponent(t)).join('&') : '')),
    searchByOwnerName: (name) => http(`/pets/search?name=${encodeURIComponent(name)}`),
};
const BoardingAPI = {
    list: () => http('/boarding-records'),
    get: (id) => http(`/boarding-records/${id}`),
    create: (data) => http('/boarding-records', { method: 'POST', body: data }),
    checkout: (data) => http('/boarding-records/check-out', { method: 'POST', body: data }),
    active: () => http('/boarding-records/active'),
    byPet: (petId) => http(`/boarding-records/pet/${petId}`),
    byOwner: (ownerId) => http(`/boarding-records/owner/${ownerId}`),
    filter: (data) => http('/boarding-records/filter', { method: 'POST', body: data }),
    myActive: () => http('/boarding-records/my-active'),
    myHistory: () => http('/boarding-records/my-history'),
};
const CareNotesAPI = {
    create: (data) => http('/care-notes', { method: 'POST', body: data }),
    listByRecord: (recordId) => http(`/care-notes/record/${recordId}`),
};
const DashboardAPI = {
    overview: () => http('/dashboard/overview'),
    revenue: (year, groupBy) => http(`/dashboard/revenue?year=${year}&groupBy=${groupBy}`),
};

function previewFee({ checkIn, checkOutExpected, actualDate, dailyFee }) {
    const plannedDays = daysBetween(checkIn, checkOutExpected);
    const actualDays = daysBetween(checkIn, actualDate);
    const isLate = actualDays > plannedDays;
    const lateDays = isLate ? actualDays - plannedDays : 0;
    const baseFee = isLate ? actualDays * dailyFee : plannedDays * dailyFee;
    const lateFee = lateDays * dailyFee * 0.2;
    const subtotal = baseFee + lateFee;
    let discountPct = 0;
    if (actualDays >= 14) discountPct = 0.10; else if (actualDays >= 7) discountPct = 0.05;
    const discount = subtotal * discountPct;
    return { plannedDays, actualDays, isLate, lateDays, baseFee, lateFee, discountPct, discount, totalFee: subtotal - discount };
}
function feePreviewHtml(fee) {
    const row = (k, v, big) => `<div class="detail-row"><span class="k">${k}</span><span class="v ${big ? 'big' : ''}">${v}</span></div>`;
    let html = '';
    if (fee.isLate) {
        html += row('Số ngày thực tế (trả trễ)', `${fee.actualDays} ngày`);
        html += row('Phí cơ bản (tính lại theo ngày thực tế)', fmtVND(fee.baseFee));
        html += row(`Phụ thu trễ ${fee.lateDays} ngày (20%)`, fmtVND(fee.lateFee));
    } else {
        html += row('Số ngày dự kiến', `${fee.plannedDays} ngày`);
        html += row('Phí cơ bản', fmtVND(fee.baseFee));
    }
    if (fee.discountPct > 0) html += row(`Giảm giá (gửi ${fee.actualDays} ngày, -${Math.round(fee.discountPct * 100)}%)`, `-${fmtVND(fee.discount)}`);
    html += row('Tổng cộng (ước tính)', fmtVND(fee.totalFee), true);
    return html;
}

function careNotesHtml(notes) {
    if (!notes || !notes.length) return `<div class="pin-note">${ICONS.note} Chưa có ghi chú chăm sóc nào.</div>`;
    return notes.map(n => `<div class="care-note"><div class="txt">${escapeHtml(n.note)}</div><div class="ts">${ICONS.clock} ${fmtDateTime(n.createdAt)}</div></div>`).join('');
}

function boardingDetailRows(r, { withOwner }) {
    const pet = r.petResponse || {};
    const owner = pet.owner || null;
    const rows = [{ k: 'Thú cưng', v: `${petEmoji(pet.type)} ${escapeHtml(pet.name || '—')} (${pet.type || '—'})` }];
    if (withOwner && owner) rows.push({ k: 'Chủ nuôi', v: `${escapeHtml(owner.name)} · ${escapeHtml(owner.phone || '')}` });
    rows.push(
        { k: 'Check-in', v: fmtDate(r.checkInDate) },
        { k: 'Ngày trả dự kiến', v: r.expectedCheckOut ? fmtDate(r.expectedCheckOut) : '—', muted: !r.expectedCheckOut },
        { k: 'Thực tế trả', v: r.actualCheckOut ? fmtDate(r.actualCheckOut) : '—', muted: !r.actualCheckOut },
        { k: 'Đơn giá / ngày', v: fmtVND(r.dailyFee) },
    );
    if (r.status === 'BOARDING') {
        const est = previewFee({ checkIn: r.checkInDate, checkOutExpected: r.expectedCheckOut, actualDate: todayISO(), dailyFee: r.dailyFee });
        const overdue = est.actualDays > est.plannedDays;
        rows.push({ k: 'Đã gửi (ước tính)', v: `${Math.max(1, est.actualDays)} ngày` });
        rows.push(overdue ? { k: 'Còn lại đến hạn', v: 'Đã quá hạn dự kiến', warn: true } : { k: 'Còn lại đến hạn', v: `${Math.max(0, est.plannedDays - est.actualDays)} ngày` });
        rows.push({ k: 'Chi phí tạm tính', v: fmtVND(est.totalFee), big: true });
    } else {
        rows.push({ k: 'Số ngày thực gửi', v: `${stayDays(r.checkInDate, r.actualCheckOut) ?? '—'} ngày` });
        rows.push({ k: 'Phí cơ bản', v: fmtVND(r.baseFee), muted: r.baseFee == null });
        if (r.lateFee) rows.push({ k: 'Phụ thu trễ', v: fmtVND(r.lateFee) });
        if (r.discount) rows.push({ k: 'Giảm giá', v: `-${fmtVND(r.discount)}` });
        rows.push({ k: 'Tổng phí', v: r.totalFee != null ? fmtVND(r.totalFee) : 'Chưa tính', big: true, muted: r.totalFee == null });
    }
    rows.push({ k: 'Trạng thái', v: boardingBadge(r.status), raw: true }, { k: 'Ghi chú', v: r.notes ? escapeHtml(r.notes) : '—', muted: !r.notes });
    return rows.map(row => `<div class="detail-row"><span class="k">${row.k}</span><span class="v ${row.muted ? 'muted' : ''} ${row.big ? 'big' : ''} ${row.warn ? 'warn' : ''}">${row.v}</span></div>`).join('');
}

const ROUTES = {
    'admin/dashboard': { role: 'ROLE_ADMIN', el: 'route-admin-dashboard', init: initDashboard, nav: 'dashboard' },
    'admin/owners': { role: 'ROLE_ADMIN', el: 'route-admin-owners', init: initOwners, nav: 'owners' },
    'admin/pets': { role: 'ROLE_ADMIN', el: 'route-admin-pets', init: initAdminPets, nav: 'pets' },
    'admin/boarding': { role: 'ROLE_ADMIN', el: 'route-admin-boarding', init: initAdminBoarding, nav: 'boarding' },
    'admin/reports': { role: 'ROLE_ADMIN', el: 'route-admin-reports', init: initReports, nav: 'reports' },
    'customer/pets': { role: 'ROLE_CUSTOMER', el: 'route-customer-pets', init: initCustomerPets, nav: 'pets' },
    'customer/boarding': { role: 'ROLE_CUSTOMER', el: 'route-customer-boarding', init: initCustomerBoarding, nav: 'boarding' },
    'customer/history': { role: 'ROLE_CUSTOMER', el: 'route-customer-history', init: initCustomerHistory, nav: 'history' },
};
function defaultRoute() { return Auth.state.role === 'ROLE_ADMIN' ? 'admin/dashboard' : 'customer/pets'; }
function navigate(route) { location.hash = '#/' + route; }

function renderRoute() {
    if (!Auth.isLoggedIn()) return;
    let key = (location.hash || '').replace(/^#\/?/, '');
    let cfg = ROUTES[key];
    if (!cfg || cfg.role !== Auth.state.role) {
        key = defaultRoute(); cfg = ROUTES[key];
        location.hash = '#/' + key;
    }
    $$('.view').forEach(v => v.hidden = true);
    $('#' + cfg.el).hidden = false;
    renderSidebar(Auth.state, cfg.nav);
    cfg.init();
}
window.addEventListener('hashchange', renderRoute);

function showApp() {
    $('#view-login').hidden = true;
    $('#view-app').hidden = false;
    if (!location.hash) location.hash = '#/' + defaultRoute(); else renderRoute();
}
function showLogin() {
    $('#view-app').hidden = true;
    $('#view-login').hidden = false;
    $('#password').value = '';
    if (loginFormV) loginFormV.resetAll();
    history.replaceState(null, '', location.pathname + location.search);
}
let loginFormV = null;

function renderSidebar(session, active) {
    const isAdmin = session.role === 'ROLE_ADMIN';
    const adminLinks = [
        { key: 'dashboard', href: '#/admin/dashboard', icon: ICONS.chart, tip: 'Dashboard' },
        { key: 'owners', href: '#/admin/owners', icon: ICONS.person, tip: 'Chủ nuôi' },
        { key: 'pets', href: '#/admin/pets', icon: ICONS.paws2, tip: 'Thú cưng' },
        { key: 'boarding', href: '#/admin/boarding', icon: ICONS.clipboard, tip: 'Phiếu gửi' },
        { key: 'reports', href: '#/admin/reports', icon: ICONS.trending, tip: 'Báo cáo' },
    ];
    const customerLinks = [
        { key: 'pets', href: '#/customer/pets', icon: ICONS.paws2, tip: 'Thú cưng của tôi' },
        { key: 'boarding', href: '#/customer/boarding', icon: ICONS.clipboard, tip: 'Đang gửi' },
        { key: 'history', href: '#/customer/history', icon: ICONS.scroll, tip: 'Lịch sử gửi' },
    ];
    const links = isAdmin ? adminLinks : customerLinks;
    const nav = links.map(l => `<a class="sidebar__link ${l.key === active ? 'is-active' : ''}" href="${l.href}">${l.icon}<span class="tip">${l.tip}</span></a>`).join('');
    $('#sidebar-root').innerHTML = `
    <aside class="sidebar">
      <div class="sidebar__logo">${ICONS.paw}</div>
      <nav class="sidebar__nav">${nav}</nav>
      <div class="sidebar__avatar" id="sidebar-avatar" title="${escapeHtml(session.username)} · ${isAdmin ? 'Quản trị' : 'Chủ nuôi'}">${Auth.initials(session.username)}</div>
    </aside>`;
    $('#sidebar-avatar').addEventListener('click', () => { if (confirm('Đăng xuất khỏi PawTrack?')) Auth.logout(); });
}

async function initDashboard() {
    const grid = $('#dash-stats');
    grid.innerHTML = `<div class="spinner-row"><span class="spinner"></span> Đang tải...</div>`;
    try {
        const year = new Date().getFullYear();
        const [overview, revenue, records] = await Promise.all([
            DashboardAPI.overview(), DashboardAPI.revenue(year, 'month'), BoardingAPI.list(),
        ]);
        renderDashStats(overview);
        renderDashRevenue(revenue);
        renderDashDistribution(overview.petDistribution || []);
        setupRecentBoardingTable(records || []);
    } catch (err) { grid.innerHTML = ''; toast(err.message, 'error'); }
}
function renderDashStats(o) {
    $('#dash-stats').innerHTML = `
    <div class="stat"><div class="stat__top"><div class="stat__icon">${ICONS.person}</div></div><div class="stat__value">${o.totalOwners}</div><div class="stat__label">CHỦ NUÔI</div></div>
    <div class="stat"><div class="stat__top"><div class="stat__icon">${ICONS.paws2}</div></div><div class="stat__value">${o.totalPets}</div><div class="stat__label">THÚ CƯNG</div></div>
    <div class="stat"><div class="stat__top"><div class="stat__icon">${ICONS.clipboard}</div><span class="stat__delta flat">Active</span></div><div class="stat__value">${o.activeBoardingCount}</div><div class="stat__label">ĐANG GỬI</div></div>
    <div class="stat"><div class="stat__top"><div class="stat__icon">${ICONS.money}</div></div><div class="stat__value">${fmtVND(o.totalRevenue)}</div><div class="stat__label">DOANH THU</div></div>
    <div class="stat"><div class="stat__top"><div class="stat__icon">${ICONS.note}</div></div><div class="stat__value">${o.totalCareNotes}</div><div class="stat__label">GHI CHÚ</div></div>`;
}
function renderDashRevenue(rows) {
    rows = rows || [];
    const max = Math.max(1, ...rows.map(r => r.revenue || 0));
    const total = rows.reduce((s, r) => s + (r.revenue || 0), 0);
    $('#dash-revenue-total').textContent = fmtVND(total);
    const peakIdx = rows.reduce((best, r, i, arr) => (r.revenue || 0) > (arr[best].revenue || 0) ? i : best, 0);
    $('#dash-revenue-bars').innerHTML = rows.map((r, i) => `
    <div class="bar-col"><div class="bar ${i === peakIdx && r.revenue > 0 ? 'is-peak' : ''}" style="height:${Math.max(3, (r.revenue || 0) / max * 100)}%" data-val="${escapeHtml(r.label)}: ${fmtVND(r.revenue)}"></div><div class="bar-label">T${r.period}</div></div>`).join('');
}
function renderDashDistribution(dist) {
    $('#dash-distribution').innerHTML = (dist || []).map(d => {
        const type = d.type;
        const pct = d.percentage;
        return `<div class="dist-row"><div class="dist-row__top"><span class="name">${petEmoji(type)} ${type}</span><span class="val"><b>${d.count}</b> ${Math.round(pct)}%</span></div><div class="dist-track"><div class="dist-fill" style="width:${pct}%"></div></div></div>`;
    }).join('') || `<div class="pin-note">${ICONS.pin} Chưa có dữ liệu.</div>`;
}

function setupRecentBoardingTable(allRows) {
    let filter = 'ALL';
    function render() {
        let rows = filter === 'ALL' ? allRows : allRows.filter(r => r.status === filter);
        rows = rows.slice().sort((a, b) => (b.checkInDate || '').localeCompare(a.checkInDate || '')).slice(0, 5);
        $('#dash-recent-count').textContent = rows.length;
        $('#dash-recent-body').innerHTML = rows.length ? rows.map(r => {
            const pet = r.petResponse || {};
            return `<tr>
        <td><div class="avatar-cell"><div class="avatar-emoji">${pet.imageUrl  ? `<img src="${pet.imageUrl}"/>` : `${petEmoji(pet.type)}`}</div><div><div class="cell-primary">${escapeHtml(pet.name || '—')}</div><div class="cell-sub">${pet.type || ''}</div></div></div></td>
        <td>${escapeHtml((pet.owner && pet.owner.name) || '—')}</td>
        <td>${fmtDate(r.checkInDate)}</td>
        <td>${boardingBadge(r.status)}</td>
        <td class="num">${r.totalFee != null ? fmtVND(r.totalFee) : '—'}</td>
        <td><button class="icon-btn" data-view="${r.id}">${ICONS.eye}</button></td>
      </tr>`;
        }).join('') : `<tr><td colspan="6"><div class="table-empty">${ICONS.paw}<div>Chưa có phiếu gửi nào.</div></div></td></tr>`;
        $$('[data-view]', $('#dash-recent-body')).forEach(b => b.addEventListener('click', () => openAdminBoardingDetail(b.dataset.view, render)));
    }
    $('#dash-recent-filters').innerHTML = [['ALL', 'Tất cả'], ['BOARDING', 'Đang gửi'], ['RETURNED', 'Đã trả']].map(([k, l]) =>
        `<button class="chip ${filter === k ? 'is-active' : ''}" data-k="${k}">${l}</button>`).join('');
    $$('#dash-recent-filters .chip').forEach(b => b.addEventListener('click', () => {
        filter = b.dataset.k;
        $$('#dash-recent-filters .chip').forEach(x => x.classList.toggle('is-active', x === b));
        render();
    }));
    render();
}

let ownersCache = [];
function initOwners() {
    const saved = Store.get('owners-filters', {});
    let page = 1, sortAsc = saved.sortAsc !== undefined ? saved.sortAsc : true, query = saved.query || '';
    const PAGE_SIZE = 6;
    $('#owners-search').value = query;
    function persist() { Store.set('owners-filters', { query, sortAsc }); }

    async function load() {
        try { ownersCache = query ? await OwnersAPI.search(query) : await OwnersAPI.list(); }
        catch (err) { toast(err.message, 'error'); ownersCache = []; }
        ownersCache.sort((a, b) => sortAsc ? a.name.localeCompare(b.name) : b.name.localeCompare(a.name));
        $('#owners-total-count').textContent = ownersCache.length;
        render();
    }
    function render() {
        const rows = paginate(ownersCache, page, PAGE_SIZE);
        $('#owners-body').innerHTML = rows.length ? rows.map(o => `
      <tr>
        <td class="cell-primary">${escapeHtml(o.name)}</td>
        <td>${escapeHtml(o.phone)}</td>
        <td class="cell-sub">${escapeHtml(o.email || '—')}</td>
        <td>${(o.pets || []).length} ${ICONS.paws2}</td>
        <td>${accountBadge(!!o.userResponse)}</td>
        <td class="actions-cell">
          <button class="icon-btn" data-view="${o.id}" title="Xem">${ICONS.eye}</button>
          <button class="icon-btn" data-edit="${o.id}" title="Sửa">${ICONS.pencil}</button>
          <button class="icon-btn danger" data-del="${o.id}" title="Xóa">${ICONS.trash}</button>
        </td>
      </tr>`).join('') : `<tr><td colspan="6"><div class="table-empty">${ICONS.person}<div>Không tìm thấy chủ nuôi nào.</div></div></td></tr>`;
        renderPager($('#owners-pager'), ownersCache.length, page, PAGE_SIZE, p => { page = p; render(); });
        $$('[data-view]', $('#owners-body')).forEach(b => b.addEventListener('click', () => openOwnerDetail(b.dataset.view)));
        $$('[data-edit]', $('#owners-body')).forEach(b => b.addEventListener('click', () => openOwnerForm('edit', b.dataset.edit)));
        $$('[data-del]', $('#owners-body')).forEach(b => b.addEventListener('click', () => removeOwner(b.dataset.del)));
    }
    $('#owners-search').oninput = debounce(e => { query = e.target.value.trim(); page = 1; persist(); load(); }, 300);
    $('#owners-sort-name').onclick = () => { sortAsc = !sortAsc; persist(); load(); };
    $('#owners-open-add').innerHTML = `${ICONS.plus} Thêm chủ nuôi`;
    $('#owners-open-add').onclick = () => openOwnerForm('add');

    load();
}

function accountSectionHtml(owner) {
    if (owner && owner.userResponse) {
        return `<div class="field-lock-title">${ICONS.lock} TÀI KHOẢN CUSTOMER</div><div class="pin-note">${ICONS.check} Đã có tài khoản đăng nhập: <b>${escapeHtml(owner.userResponse.username)}</b>${owner.userResponse.enable === false ? ' (đã khóa)' : ''}</div>`;
    }
    return `<div class="field-lock-title">${ICONS.lock} TẠO TÀI KHOẢN CUSTOMER</div>
    <div class="field-hint" style="margin-bottom:10px;">Tên đăng nhập sẽ được hệ thống tự tạo (theo số điện thoại của chủ nuôi). Để trống nếu chưa cần tạo tài khoản ngay.</div>
    <div class="field"><label>Mật khẩu tạm</label><input class="input" id="of-password" placeholder="Tối thiểu 6 ký tự"><div class="field-error" id="of-password-err"></div></div>`;
}

let editingOwnerId = null;
let ownerFormV = null;
function openOwnerForm(mode, id) {
    editingOwnerId = mode === 'edit' ? Number(id) : null;
    const owner = editingOwnerId ? ownersCache.find(o => o.id === editingOwnerId) : null;
    $('#of-title').textContent = mode === 'edit' ? 'Chỉnh sửa chủ nuôi' : 'Thêm chủ nuôi';
    $('#of-name').value = owner ? owner.name : '';
    $('#of-phone').value = owner ? owner.phone : '';
    $('#of-email').value = owner ? (owner.email || '') : '';
    $('#of-address').value = owner ? (owner.address || '') : '';
    $('#of-account-section').innerHTML = editingOwnerId
        ? accountSectionHtml(owner)
        : `<div class="field-lock-title">${ICONS.lock} TẠO TÀI KHOẢN CUSTOMER (TÙY CHỌN)</div>
       <div class="field-hint" style="margin-bottom:10px;">Để trống nếu chưa cần tạo tài khoản ngay — có thể tạo sau từ màn hình chỉnh sửa. Tên đăng nhập sẽ tự động theo số điện thoại.</div>
       <div class="field"><label>Mật khẩu tạm</label><input class="input" id="of-password" placeholder="Tối thiểu 6 ký tự"><div class="field-error" id="of-password-err"></div></div>`;

    if (!ownerFormV) {
        ownerFormV = bindForm([
            ['name', $('#of-name'), document.getElementById('of-name-err'), v => Rules.required(v) || Rules.maxLen(100)(v)],
            ['phone', $('#of-phone'), document.getElementById('of-phone-err'), Rules.phone],
            ['email', $('#of-email'), document.getElementById('of-email-err'), Rules.email],
            ['address', $('#of-address'), document.getElementById('of-address-err'), Rules.maxLen(255)],
        ], $('#of-submit'));
    }

    ownerFormV.setField('password', $('#of-password'), document.getElementById('of-password-err'), v => Rules.minLen(6)(v) || Rules.maxLen(255)(v));
    ownerFormV.resetAll();
    openModal('modal-owner-form');
}
document.addEventListener('DOMContentLoaded', () => {
    $('#of-submit').innerHTML = `${ICONS.save} Lưu`;
    $('#of-submit').addEventListener('click', async () => {
        const name = $('#of-name').value.trim();
        const phone = $('#of-phone').value.trim();
        const data = { name, phone, email: $('#of-email').value.trim() || null, address: $('#of-address').value.trim() || null };

        const pwdInput = $('#of-password');
        const pwd = pwdInput ? pwdInput.value.trim() : '';

        try {
            let owner;
            if (editingOwnerId) {
                owner = await OwnersAPI.update(editingOwnerId, data);
                if (pwd) {
                    await UsersAPI.createAccount({ password: pwd, ownerId: editingOwnerId, enable: true });
                    toast('Đã tạo tài khoản Customer cho chủ nuôi');
                }
            } else {
                if (pwd) data.userRequest = { password: pwd, enable: true };
                owner = await OwnersAPI.create(data);
                if (pwd) toast('Đã thêm chủ nuôi và tạo tài khoản Customer');
            }
            closeModal('modal-owner-form');
            if (!pwd) toast(editingOwnerId ? 'Đã cập nhật chủ nuôi' : 'Đã thêm chủ nuôi mới');
            initOwners();
        } catch (err) { toast(err.message, 'error'); }
    });
});

async function openOwnerDetail(id) {
    let o;
    try { o = await OwnersAPI.get(id); } catch (err) { toast(err.message, 'error'); return; }
    $('#od-name').textContent = o.name;
    const pets = o.pets || [];
    const petsHtml = pets.length
        ? `<div style="display:flex;gap:8px;flex-wrap:wrap;">${pets.map(p => `<span class="chip" style="cursor:default;">${petEmoji(p.type)} ${escapeHtml(p.name)}</span>`).join('')}</div>`
        : `<span class="v muted">Chưa có thú cưng</span>`;
    $('#od-fields').innerHTML = `
    <div class="detail-row"><span class="k">Điện thoại</span><span class="v">${o.phone}</span></div>
    <div class="detail-row"><span class="k">Email</span><span class="v">${o.email || '—'}</span></div>
    <div class="detail-row"><span class="k">Địa chỉ</span><span class="v">${o.address || '—'}</span></div>
    <div class="detail-row"><span class="k">Tài khoản</span><span class="v">${accountBadge(!!o.userResponse)}</span></div>
    <div class="detail-row" style="flex-direction:column;align-items:flex-start;gap:8px;"><span class="k">Thú cưng</span>${petsHtml}</div>`;
    $('#od-edit-btn').innerHTML = `${ICONS.pencil} Chỉnh sửa`;
    $('#od-edit-btn').onclick = () => { closeModal('modal-owner-detail'); openOwnerForm('edit', o.id); };
    openModal('modal-owner-detail');
}
async function removeOwner(id) {
    const o = ownersCache.find(x => x.id === Number(id));
    const name = o ? o.name : `#${id}`;
    let records = [];
    try { records = await BoardingAPI.byOwner(id); }
    catch (err) { toast(err.message, 'error'); return; }
    if (records && records.length) {
        alert(`Không thể xóa "${name}" vì chủ nuôi này (hoặc thú cưng của họ) đã có ${records.length} phiếu gửi trong hệ thống.\n\nVui lòng xóa/lưu trữ các phiếu gửi liên quan trước, hoặc liên hệ quản trị viên nếu thực sự cần xóa dữ liệu này.`);
        return;
    }
    if (!confirm(`Xóa chủ nuôi "${name}"? Hành động này không thể hoàn tác.`)) return;
    try { await OwnersAPI.remove(id); toast('Đã xóa chủ nuôi'); initOwners(); }
    catch (err) { toast(err.message, 'error'); }
}

let petsAllCache = [];
let ownersAllCache = [];
function initAdminPets() {
    const saved = Store.get('pets-filters', {});
    let typeFilter = saved.typeFilter || 'ALL', query = saved.query || '', page = 1;
    const PAGE_SIZE = 6;
    $('#pets-search').value = query;
    function persist() { Store.set('pets-filters', { typeFilter, query }); }

    async function load() {
        try {
            const [pets, owners] = await Promise.all([PetsAPI.list(), OwnersAPI.list()]);
            petsAllCache = pets; ownersAllCache = owners;
        } catch (err) { toast(err.message, 'error'); petsAllCache = []; ownersAllCache = []; }
        render();
    }
    function filtered() {
        return petsAllCache.filter(p => {
            if (typeFilter !== 'ALL' && p.type !== typeFilter) return false;
            if (query) {
                const s = query.toLowerCase();
                const ownerName = (p.owner && p.owner.name || '').toLowerCase();
                if (!p.name.toLowerCase().includes(s) && !ownerName.includes(s)) return false;
            }
            return true;
        });
    }
    function render() {
        const rows = filtered();
        const pageRows = paginate(rows, page, PAGE_SIZE);
        $('#pets-body').innerHTML = pageRows.length ? pageRows.map(p => `
      <tr>
        <td><div class="avatar-cell"><div class="avatar-emoji"> ${p.imageUrl  ? `<img src="${p.imageUrl}"/>` : `${petEmoji(p.type)}`} </div><div class="cell-primary">${escapeHtml(p.name)}</div></div></td>
        <td>${p.type}</td>
        <td class="cell-sub">${escapeHtml(p.breed || '—')}</td>
        <td>${p.age != null ? p.age + ' tuổi' : '—'}</td>
        <td>${p.weight != null ? p.weight + ' kg' : '—'}</td>
        <td>${escapeHtml((p.owner && p.owner.name) || '—')}</td>
        <td>${petStatusBadge(p.status)}</td>
        <td class="actions-cell">
          <button class="icon-btn" data-view="${p.id}" title="Xem">${ICONS.eye}</button>
          <button class="icon-btn" data-edit="${p.id}" title="Sửa">${ICONS.pencil}</button>
          <button class="icon-btn danger" data-del="${p.id}" title="Xóa">${ICONS.trash}</button>
        </td>
      </tr>`).join('') : `<tr><td colspan="8"><div class="table-empty">${ICONS.paws2}<div>Không tìm thấy thú cưng nào.</div></div></td></tr>`;
        renderPager($('#pets-pager'), rows.length, page, PAGE_SIZE, p => { page = p; render(); });
        $$('[data-view]', $('#pets-body')).forEach(b => b.addEventListener('click', () => openAdminPetDetail(b.dataset.view)));
        $$('[data-edit]', $('#pets-body')).forEach(b => b.addEventListener('click', () => openPetForm('edit', b.dataset.edit)));
        $$('[data-del]', $('#pets-body')).forEach(b => b.addEventListener('click', () => removePet(b.dataset.del)));
    }
    $('#pets-type-filters').innerHTML = [['ALL', 'Tất cả'], ['DOG', '🐶 Dog'], ['CAT', '🐱 Cat'], ['BIRD', '🐦 Bird'], ['RABBIT', '🐰 Rabbit'], ['OTHER', '🐾 Other']]
        .map(([k, l]) => `<button class="chip ${typeFilter === k ? 'is-active' : ''}" data-k="${k}">${l}</button>`).join('');
    $$('#pets-type-filters .chip').forEach(b => b.addEventListener('click', () => {
        typeFilter = b.dataset.k; page = 1; persist();
        $$('#pets-type-filters .chip').forEach(x => x.classList.toggle('is-active', x === b));
        render();
    }));
    $('#pets-search').oninput = debounce(e => { query = e.target.value.trim(); page = 1; persist(); render(); }, 280);
    $('#pets-open-add').innerHTML = `${ICONS.plus} Thêm thú cưng`;
    $('#pets-open-add').onclick = () => openPetForm('add');

    load();
}

let editingPetId = null;
let petFormV = null;
function openPetForm(mode, id) {
    editingPetId = mode === 'edit' ? Number(id) : null;
    const pet = editingPetId ? petsAllCache.find(p => p.id === editingPetId) : null;
    $('#pf-title').textContent = mode === 'edit' ? 'Chỉnh sửa thú cưng' : 'Thêm thú cưng';
    $('#pf-owner').innerHTML = `<option value="">-- Chọn chủ nuôi --</option>` +
        ownersAllCache.map(o => `<option value="${o.id}" ${pet && pet.ownerId === o.id ? 'selected' : ''}>${escapeHtml(o.name)} — ${escapeHtml(o.phone)}</option>`).join('');
    $('#pf-name').value = pet ? pet.name : '';
    $('#pf-type').value = pet ? pet.type : '';
    $('#pf-breed').value = pet ? (pet.breed || '') : '';
    $('#pf-age').value = pet ? (pet.age ?? '') : '';
    $('#pf-weight').value = pet ? (pet.weight ?? '') : '';
    $('#pf-image').value = pet ? (pet.imageUrl || '') : '';

    if (!petFormV) {
        petFormV = bindForm([
            ['owner', $('#pf-owner'), document.getElementById('pf-owner-err'), Rules.select],
            ['name', $('#pf-name'), document.getElementById('pf-name-err'), v => Rules.required(v) || Rules.maxLen(100)(v)],
            ['type', $('#pf-type'), document.getElementById('pf-type-err'), Rules.select],
            ['breed', $('#pf-breed'), document.getElementById('pf-breed-err'), Rules.maxLen(100)],
            ['age', $('#pf-age'), document.getElementById('pf-age-err'), Rules.intRange(0, 500)],
            ['weight', $('#pf-weight'), document.getElementById('pf-weight-err'), Rules.decimalRange(0.01, 999.99)],
            ['image', $('#pf-image'), document.getElementById('pf-image-err'), Rules.maxLen(500)],
        ], $('#pf-submit'));
    }
    petFormV.resetAll();
    openModal('modal-pet-form');
}
document.addEventListener('DOMContentLoaded', () => {
    $('#pf-submit').innerHTML = `${ICONS.save} Lưu`;
    $('#pf-submit').addEventListener('click', async () => {
        const data = {
            ownerId: Number($('#pf-owner').value),
            name: $('#pf-name').value.trim(),
            type: $('#pf-type').value,
            breed: $('#pf-breed').value.trim() || null,
            age: Number($('#pf-age').value),
            weight: Number($('#pf-weight').value),
            imageUrl: $('#pf-image').value.trim() || null,
        };
        try {
            if (editingPetId) await PetsAPI.update(editingPetId, data);
            else await PetsAPI.create(data);
            closeModal('modal-pet-form');
            toast(editingPetId ? 'Đã cập nhật thú cưng' : 'Đã thêm thú cưng mới');
            initAdminPets();
        } catch (err) { toast(err.message, 'error'); }
    });
});

async function openAdminPetDetail(id) {
    let p;
    try { p = await PetsAPI.get(id); } catch (err) { toast(err.message, 'error'); return; }
    let history = [];
    try { history = await BoardingAPI.byPet(id); } catch (e) { /* non-fatal */ }
    const last = history[0];
    $('#pd-name').innerHTML = `${p.imageUrl  ? `<img src="${p.imageUrl}"/>` : `<h2> ${petEmoji(p.type)} <h2>`} ${p.name}`;
    $('#pd-fields').innerHTML = `
    <div class="detail-row"><span class="k">Chủ nuôi</span><span class="v">${escapeHtml(p.owner ? p.owner.name : '—')}</span></div>
    <div class="detail-row"><span class="k">Loại</span><span class="v">${p.type}</span></div>
    <div class="detail-row"><span class="k">Giống</span><span class="v">${escapeHtml(p.breed || '—')}</span></div>
    <div class="detail-row"><span class="k">Tuổi</span><span class="v">${p.age != null ? p.age + ' tuổi' : '—'}</span></div>
    <div class="detail-row"><span class="k">Cân nặng</span><span class="v">${p.weight != null ? p.weight + ' kg' : '—'}</span></div>
    <div class="detail-row"><span class="k">Trạng thái</span><span class="v">${petStatusBadge(p.status)}</span></div>
    <div class="detail-row"><span class="k">Lần gửi cuối</span><span class="v ${!last ? 'muted' : ''}">${last ? fmtDate(last.checkInDate) + ' → ' + (last.actualCheckOut ? fmtDate(last.actualCheckOut) : '—') : 'Chưa từng gửi'}</span></div>
    <div class="detail-row"><span class="k">Tổng lượt gửi</span><span class="v">${history.length} lần</span></div>`;
    openModal('modal-pet-detail');
}
async function removePet(id) {
    const p = petsAllCache.find(x => x.id === Number(id));
    const name = p ? p.name : `#${id}`;
    let history = [];
    try { history = await BoardingAPI.byPet(id); }
    catch (err) { toast(err.message, 'error'); return; }
    if (history && history.length) {
        alert(`Không thể xóa "${name}" vì thú cưng này đã có ${history.length} phiếu gửi (đã hoặc đang sử dụng dịch vụ).\n\nVui lòng xóa/lưu trữ các phiếu gửi liên quan trước, hoặc liên hệ quản trị viên nếu thực sự cần xóa dữ liệu này.`);
        return;
    }
    if (!confirm(`Xóa thú cưng "${name}"? Hành động này không thể hoàn tác.`)) return;
    try { await PetsAPI.remove(id); toast('Đã xóa thú cưng'); initAdminPets(); }
    catch (err) { toast(err.message, 'error'); }
}

let brecFilteredCache = [];
function initAdminBoarding() {
    const saved = Store.get('boarding-filters', {});
    let statusFilter = saved.statusFilter || 'ALL', query = saved.query || '', page = 1;
    const PAGE_SIZE = 6;
    $('#brec-search').value = query;
    $('#brec-type-filter').value = saved.typeFilter || '';
    $('#brec-from-date').value = saved.fromDate || '';
    $('#brec-to-date').value = saved.toDate || '';
    function persist() {
        Store.set('boarding-filters', {
            statusFilter, query,
            typeFilter: $('#brec-type-filter').value,
            ownerId: $('#brec-owner-filter').value,
            fromDate: $('#brec-from-date').value,
            toDate: $('#brec-to-date').value,
        });
    }

    async function loadOwnerOptions() {
        try {
            ownersAllCache = await OwnersAPI.list();
            $('#brec-owner-filter').innerHTML = `<option value="">Tất cả chủ nuôi</option>` + ownersAllCache.map(o => `<option value="${o.id}">${escapeHtml(o.name)} — ${escapeHtml(o.phone)}</option>`).join('');
            if (saved.ownerId) $('#brec-owner-filter').value = saved.ownerId;
        } catch (err) { toast(err.message, 'error'); }
    }

    async function fetchFiltered() {
        const body = {
            petType: $('#brec-type-filter').value || null,
            ownerId: $('#brec-owner-filter').value ? Number($('#brec-owner-filter').value) : null,
            fromDate: $('#brec-from-date').value || null,
            toDate: $('#brec-to-date').value || null,
        };
        try { brecFilteredCache = await BoardingAPI.filter(body); }
        catch (err) { toast(err.message, 'error'); brecFilteredCache = []; }
        renderTabs();
        applyLocalFilter();
    }

    function renderTabs() {
        const counts = {
            ALL: brecFilteredCache.length,
            BOARDING: brecFilteredCache.filter(r => r.status === 'BOARDING').length,
            RETURNED: brecFilteredCache.filter(r => r.status === 'RETURNED').length
        };
        $('#brec-tabs').innerHTML = [['ALL', 'Tất cả'], ['BOARDING', 'Đang gửi'], ['RETURNED', 'Đã trả']].map(([k, l]) =>
            `<button class="tab ${statusFilter === k ? 'is-active' : ''}" data-k="${k}">${l} <span class="count">${counts[k]}</span></button>`).join('');
        $$('#brec-tabs .tab').forEach(b => b.addEventListener('click', () => { statusFilter = b.dataset.k; page = 1; persist(); renderTabs(); applyLocalFilter(); }));
    }

    function applyLocalFilter() {
        let rows = statusFilter === 'ALL' ? brecFilteredCache : brecFilteredCache.filter(r => r.status === statusFilter);
        if (query) {
            const s = query.toLowerCase();
            rows = rows.filter(r => {
                const pet = r.petResponse || {};
                const ownerName = (pet.owner && pet.owner.name || '').toLowerCase();
                return pet.name.toLowerCase().includes(s) || ownerName.includes(s);
            });
        }
        render(rows);
    }

    function render(rows) {
        const pageRows = paginate(rows, page, PAGE_SIZE);
        $('#brec-body').innerHTML = pageRows.length ? pageRows.map((r, i) => {
            const pet = r.petResponse || {};
            return `<tr>
        <td class="cell-sub">${(page - 1) * PAGE_SIZE + i + 1}</td>
        <td><div class="avatar-cell"><div class="avatar-emoji">${pet.imageUrl  ? `<img src="${pet.imageUrl}"/>` : `${petEmoji(pet.type)}`}</div><div><div class="cell-primary">${escapeHtml(pet.name || '—')}</div><div class="cell-sub">${pet.type || ''}</div></div></div></td>
        <td>${escapeHtml((pet.owner && pet.owner.name) || '—')}</td>
        <td>${fmtDate(r.checkInDate)}</td>
        <td class="cell-sub">${fmtDate(r.expectedCheckOut)}</td>
        <td class="cell-sub">${r.actualCheckOut ? fmtDate(r.actualCheckOut) : '—'}</td>
        <td class="num cell-primary">${r.totalFee != null ? fmtVND(r.totalFee) : '—'}</td>
        <td>${boardingBadge(r.status)}</td>
        <td class="actions-cell">
          <button class="icon-btn" data-view="${r.id}" title="Xem chi tiết">${ICONS.eye}</button>
          <button class="icon-btn ${r.status === 'BOARDING' ? 'on' : ''}" data-checkout="${r.id}" title="${r.status === 'BOARDING' ? 'Check-out' : 'Đã trả'}" ${r.status !== 'BOARDING' ? 'disabled' : ''}>${ICONS.check}</button>
        </td>
      </tr>`;
        }).join('') : `<tr><td colspan="9"><div class="table-empty">${ICONS.clipboard}<div>Không tìm thấy phiếu gửi nào.</div></div></td></tr>`;
        renderPager($('#brec-pager'), rows.length, page, PAGE_SIZE, p => { page = p; applyLocalFilter(); });
        $$('[data-view]', $('#brec-body')).forEach(b => b.addEventListener('click', () => openAdminBoardingDetail(b.dataset.view, fetchFiltered)));
        $$('[data-checkout]', $('#brec-body')).forEach(b => b.addEventListener('click', () => startCheckout(b.dataset.checkout, fetchFiltered)));
    }

    function checkDateRange() {
        const from = $('#brec-from-date'), to = $('#brec-to-date');
        if (from.value && to.value && to.value < from.value) {
            setFieldError(from, document.getElementById('brec-date-err'), 'Đến ngày phải sau hoặc bằng Từ ngày');
            to.classList.add('is-invalid');
            return false;
        }
        clearFieldError(from, document.getElementById('brec-date-err'));
        to.classList.remove('is-invalid');
        return true;
    }

    $('#brec-type-filter').onchange = () => { page = 1; persist(); fetchFiltered(); };
    $('#brec-owner-filter').onchange = () => { page = 1; persist(); fetchFiltered(); };
    $('#brec-from-date').onchange = () => { page = 1; persist(); if (checkDateRange()) fetchFiltered(); };
    $('#brec-to-date').onchange = () => { page = 1; persist(); if (checkDateRange()) fetchFiltered(); };
    $('#brec-clear-filters').onclick = () => {
        $('#brec-type-filter').value = ''; $('#brec-owner-filter').value = ''; $('#brec-from-date').value = ''; $('#brec-to-date').value = '';
        $('#brec-search').value = ''; query = ''; page = 1;
        persist();
        checkDateRange();
        fetchFiltered();
    };
    $('#brec-search').oninput = debounce(e => { query = e.target.value.trim(); page = 1; persist(); applyLocalFilter(); }, 280);

    $$('[data-open-create-boarding]').forEach(btn => { btn.innerHTML = `${ICONS.plus} Tạo phiếu`; btn.onclick = () => openCreateBoardingModal(fetchFiltered); });

    loadOwnerOptions().then(fetchFiltered);
}

let cbFormV = null;
async function openCreateBoardingModal(onDone) {
    let pets = [];
    try { pets = await PetsAPI.list(); } catch (err) { toast(err.message, 'error'); return; }
    const available = pets.filter(p => p.status !== 'BOARDING');
    $('#cb-pet').innerHTML = available.length
        ? `<option value="">-- Chọn thú cưng --</option>` + available.map(p => `<option value="${p.id}">${escapeHtml(p.name)} · ${escapeHtml(p.owner ? p.owner.phone : '')} · ${escapeHtml(p.owner ? p.owner.name : '')}</option>`).join('')
        : `<option value="">Không có thú cưng nào sẵn sàng (tất cả đang gửi)</option>`;
    $('#cb-days').value = ''; $('#cb-fee').value = ''; $('#cb-note').value = ''; $('#cb-preview').textContent = '';
    function updatePreview() {
        const days = Number($('#cb-days').value), fee = Number($('#cb-fee').value);
        if (days > 0 && fee > 0) {
            const expected = addDaysISO(todayISO(), days);
            $('#cb-preview').innerHTML = `Check-in hôm nay, dự kiến trả <b>${fmtDate(expected)}</b> · Phí cơ bản dự kiến: <b>${fmtVND(days * fee)}</b>`;
        } else $('#cb-preview').textContent = '';
    }
    $('#cb-days').oninput = updatePreview;
    $('#cb-fee').oninput = updatePreview;
    $('#cb-submit').innerHTML = `${ICONS.clipboard} Tạo phiếu`;

    if (!cbFormV) {
        cbFormV = bindForm([
            ['pet', $('#cb-pet'), document.getElementById('cb-pet-err'), Rules.select],
            ['days', $('#cb-days'), document.getElementById('cb-days-err'), Rules.intRange(1, 3652)],
            ['fee', $('#cb-fee'), document.getElementById('cb-fee-err'), Rules.positiveInt],
        ], $('#cb-submit'));
    }
    cbFormV.resetAll();

    $('#cb-submit').onclick = async () => {
        try {
            await BoardingAPI.create({
                petId: Number($('#cb-pet').value),
                expectedNumberOfDayService: Number($('#cb-days').value),
                dailyFee: Number($('#cb-fee').value),
                status: 'BOARDING',
                notes: $('#cb-note').value.trim() || null,
            });
            closeModal('modal-create-boarding');
            toast('Đã tạo phiếu gửi mới');
            if (onDone) onDone();
        } catch (err) { toast(err.message, 'error'); }
    };
    openModal('modal-create-boarding');
}

async function openAdminBoardingDetail(id, onChange) {
    let r;
    try { r = await BoardingAPI.get(id); } catch (err) { toast(err.message, 'error'); return; }
    $('#bd-fields').innerHTML = boardingDetailRows(r, { withOwner: true });
    $('#bd-notes-title').innerHTML = `${ICONS.note} GHI CHÚ CHĂM SÓC`;
    $('#bd-notes').innerHTML = careNotesHtml(r.careNoteResponses);
    $('#bd-note-add').innerHTML = `${ICONS.plus} Thêm`;
    $('#bd-checkout-btn').innerHTML = `${ICONS.check} Check-out`;
    $('#bd-checkout-btn').style.display = r.status === 'BOARDING' ? '' : 'none';
    $('#bd-note-input').value = '';
    $('#bd-note-add').disabled = true;
    $('#bd-note-input').oninput = () => { $('#bd-note-add').disabled = !$('#bd-note-input').value.trim(); };
    $('#bd-note-add').onclick = async () => {
        const val = $('#bd-note-input').value.trim();
        if (!val) return;
        try {
            await CareNotesAPI.create({ boardingRecordId: Number(id), note: val });
            $('#bd-note-input').value = '';
            $('#bd-note-add').disabled = true;
            const fresh = await BoardingAPI.get(id);
            $('#bd-notes').innerHTML = careNotesHtml(fresh.careNoteResponses);
            toast('Đã thêm ghi chú chăm sóc');
        } catch (err) { toast(err.message, 'error'); }
    };
    $('#bd-checkout-btn').onclick = () => { closeModal('modal-boarding-detail'); startCheckout(id, onChange); };
    openModal('modal-boarding-detail');
}

let coFormV = null;
async function startCheckout(id, onDone) {
    let r;
    try { r = await BoardingAPI.get(id); } catch (err) { toast(err.message, 'error'); return; }
    if (r.status !== 'BOARDING') return;
    $('#co-hint').innerHTML = `${ICONS.calendar} Check-in <b>${fmtDate(r.checkInDate)}</b> · Dự kiến trả <b>${fmtDate(r.expectedCheckOut)}</b> · Ngày trả thực tế sẽ được hệ thống ghi nhận là hôm nay.`;
    $('#co-fee').value = r.dailyFee;
    function renderPreview() {
        const fee = Number($('#co-fee').value) || r.dailyFee;
        const est = previewFee({ checkIn: r.checkInDate, checkOutExpected: r.expectedCheckOut, actualDate: todayISO(), dailyFee: fee });
        $('#co-preview').innerHTML = feePreviewHtml(est);
    }
    $('#co-fee').oninput = renderPreview;
    renderPreview();
    $('#co-submit').innerHTML = `${ICONS.check} Xác nhận trả`;

    if (!coFormV) {
        coFormV = bindForm([['fee', $('#co-fee'), document.getElementById('co-fee-err'), Rules.positiveInt]], $('#co-submit'));
    }
    coFormV.resetAll();

    $('#co-submit').onclick = async () => {
        try {
            await BoardingAPI.checkout({ boardingRecordId: Number(id), dailyFee: Number($('#co-fee').value) });
            closeModal('modal-checkout');
            toast('Đã xác nhận trả thú cưng');
            if (onDone) onDone();
        } catch (err) { toast(err.message, 'error'); }
    };
    openModal('modal-checkout');
}

function initReports() {
    let year = new Date().getFullYear(), groupBy = 'month';
    let allRecordsCache = null;

    const saved = Store.get('reports-filters', null);
    if (saved && saved.year) year = saved.year;
    if (saved && saved.groupBy) groupBy = saved.groupBy;

    const currentYear = new Date().getFullYear();
    const yearOptions = Array.from(new Set([currentYear - 1, currentYear, currentYear + 1, year])).sort((a, b) => a - b);
    $('#reports-year-select').innerHTML = yearOptions.map(y => `<option value="${y}" ${y === year ? 'selected' : ''}>${y}</option>`).join('');
    $('#reports-year-label').textContent = `Tổng quan năm ${year}`;
    $('#reports-chip-month').classList.toggle('is-active', groupBy === 'month');
    $('#reports-chip-quarter').classList.toggle('is-active', groupBy === 'quarter');

    $('#reports-year-select').onchange = (e) => {
        year = Number(e.target.value);
        $('#reports-year-label').textContent = `Tổng quan năm ${year}`;
        Store.set('reports-filters', { year, groupBy });
        loadOverview();
        loadRevenue();
    };
    $('#reports-chip-month').onclick = () => setGroupBy('month');
    $('#reports-chip-quarter').onclick = () => setGroupBy('quarter');
    function setGroupBy(g) {
        groupBy = g;
        $('#reports-chip-month').classList.toggle('is-active', g === 'month');
        $('#reports-chip-quarter').classList.toggle('is-active', g === 'quarter');
        Store.set('reports-filters', { year, groupBy });
        loadRevenue();
    }

    async function loadOverview() {
        try {
            if (!allRecordsCache) allRecordsCache = await BoardingAPI.list();
            const stats = await computeYearlyOverview(year, allRecordsCache);
            const top = stats.topBoardedPet;
            $('#reports-stats').innerHTML = `
        <div class="stat"><div class="stat__top"><div class="stat__icon">${ICONS.money}</div></div><div class="stat__value">${fmtVND(stats.totalRevenue)}</div><div class="stat__label">TỔNG DOANH THU</div></div>
        <div class="stat"><div class="stat__top"><div class="stat__icon">${ICONS.person}</div></div><div class="stat__value">${stats.totalOwners}</div><div class="stat__label">TỔNG CHỦ NUÔI</div></div>
        <div class="stat"><div class="stat__top"><div class="stat__icon">${ICONS.star}</div></div><div class="stat__value" style="font-size:19px;">${top ? petEmoji(top.type) + ' ' + escapeHtml(top.name) : '—'}</div><div class="stat__label">GỬI NHIỀU NHẤT${top ? ' · ' + top.count + ' LẦN' : ''}</div></div>
        <div class="stat"><div class="stat__top"><div class="stat__icon">${ICONS.note}</div></div><div class="stat__value">${stats.totalCareNotes}</div><div class="stat__label">GHI CHÚ CHĂM SÓC</div></div>`;

            const dist = await DashboardAPI.overview().then(o => o.petDistribution || []).catch(() => []);
            $('#reports-distribution').innerHTML = dist.map(d => {
                const type = d.type, pct = d.percentage;
                return `<div class="dist-row"><div class="dist-row__top"><span class="name">${petEmoji(type)} ${type}</span><span class="val"><b>${d.count}</b> ${Math.round(pct)}%</span></div><div class="dist-track"><div class="dist-fill" style="width:${pct}%"></div></div></div>`;
            }).join('') || `<div class="pin-note">${ICONS.pin} Chưa có dữ liệu.</div>`;
        } catch (err) { toast(err.message, 'error'); }
    }
    async function loadRevenue() {
        try {
            const rows = await DashboardAPI.revenue(year, groupBy);
            const max = Math.max(1, ...rows.map(r => r.revenue || 0));
            const peakIdx = rows.reduce((best, r, i, arr) => (r.revenue || 0) > (arr[best].revenue || 0) ? i : best, 0);
            $('#reports-revenue-bars').innerHTML = rows.map((r, i) => `<div class="bar-col"><div class="bar ${i === peakIdx && r.revenue > 0 ? 'is-peak' : ''}" style="height:${Math.max(3, (r.revenue || 0) / max * 100)}%" data-val="${escapeHtml(r.label)}: ${fmtVND(r.revenue)}"></div><div class="bar-label">${groupBy === 'quarter' ? 'Q' : 'T'}${r.period}</div></div>`).join('');
        } catch (err) { toast(err.message, 'error'); }
    }

    loadOverview();
    loadRevenue();
}

async function computeYearlyOverview(year, allRecords) {
    const inYear = (dateStr) => !!dateStr && Number(String(dateStr).slice(0, 4)) === year;
    const yearRecords = allRecords.filter(r => inYear(r.checkInDate));

    const ownerIds = new Set();
    yearRecords.forEach(r => { const oid = r.petResponse && r.petResponse.owner && r.petResponse.owner.id; if (oid) ownerIds.add(oid); });

    const totalRevenue = allRecords
        .filter(r => r.status === 'RETURNED' && inYear(r.actualCheckOut))
        .reduce((s, r) => s + (r.totalFee || 0), 0);

    const petCounts = new Map();
    yearRecords.forEach(r => {
        const pet = r.petResponse;
        if (!pet) return;
        const cur = petCounts.get(pet.id) || { count: 0, pet };
        cur.count++;
        petCounts.set(pet.id, cur);
    });
    let topBoardedPet = null;
    petCounts.forEach(v => { if (!topBoardedPet || v.count > topBoardedPet.count) topBoardedPet = { name: v.pet.name, type: v.pet.type, count: v.count }; });

    const noteLists = await Promise.all(yearRecords.map(r => CareNotesAPI.listByRecord(r.id).catch(() => [])));
    const totalCareNotes = noteLists.reduce((s, notes) => s + (notes || []).length, 0);

    return { totalOwners: ownerIds.size, totalRevenue, topBoardedPet, totalCareNotes };
}

let myPetsCache = [];
function initCustomerPets() {
    const saved = Store.get('cpets-filters', {});
    let typeFilter = saved.typeFilter || 'ALL', query = saved.query || '';
    $('#cpets-search').value = query;
    function persist() { Store.set('cpets-filters', { typeFilter, query }); }

    async function load() {
        try { myPetsCache = await PetsAPI.myPets(); } catch (err) { toast(err.message, 'error'); myPetsCache = []; }
        const active = myPetsCache.filter(p => p.status === 'BOARDING').length;
        let historyCount = 0;
        try { historyCount = (await BoardingAPI.myHistory()).length; } catch (e) { /* non-fatal */ }
        $('#cpets-stats').innerHTML = `
      <div class="stat"><div class="stat__top"><div class="stat__icon">${ICONS.paws2}</div><span class="stat__delta flat">Của tôi</span></div><div class="stat__value">${myPetsCache.length}</div><div class="stat__label">THÚ CƯNG</div></div>
      <div class="stat"><div class="stat__top"><div class="stat__icon">${ICONS.clipboard}</div><span class="stat__delta flat">Active</span></div><div class="stat__value">${active}</div><div class="stat__label">ĐANG GỬI</div></div>
      <div class="stat"><div class="stat__top"><div class="stat__icon">${ICONS.scroll}</div></div><div class="stat__value">${historyCount}</div><div class="stat__label">LƯỢT GỬI</div></div>`;
        render();
    }
    function render() {
        const rows = myPetsCache.filter(p => (typeFilter === 'ALL' || p.type === typeFilter) && (!query || p.name.toLowerCase().includes(query.toLowerCase())));
        $('#cpets-body').innerHTML = rows.length ? rows.map((p, i) => `
      <tr>
        <td class="cell-sub">${i + 1}</td>
        <td><div class="avatar-cell"><div class="avatar-emoji">${p.imageUrl  ? `<img src="${p.imageUrl}"/>` : `${petEmoji(p.type)}`}</div><div class="cell-primary">${escapeHtml(p.name)}</div></div></td>
        <td>${p.type}</td>
        <td class="cell-sub">${escapeHtml(p.breed || '—')}</td>
        <td>${p.age != null ? p.age + ' tuổi' : '—'}</td>
        <td>${p.weight != null ? p.weight + ' kg' : '—'}</td>
        <td>${petStatusBadge(p.status)}</td>
        <td><button class="icon-btn" data-view="${p.id}" title="Xem">${ICONS.eye}</button></td>
      </tr>`).join('') : `<tr><td colspan="8"><div class="table-empty">${ICONS.paws2}<div>Không tìm thấy thú cưng nào.</div></div></td></tr>`;
        $$('[data-view]', $('#cpets-body')).forEach(b => b.addEventListener('click', () => openCustomerPetDetail(b.dataset.view)));
    }
    $('#cpets-type-filters').innerHTML = [['ALL', 'Tất cả'], ['DOG', '🐶 Dog'], ['CAT', '🐱 Cat'], ['BIRD', '🐦 Bird'], ['RABBIT', '🐰 Rabbit'], ['OTHER', '🐾 Other']]
        .map(([k, l]) => `<button class="chip ${typeFilter === k ? 'is-active' : ''}" data-k="${k}">${l}</button>`).join('');
    $$('#cpets-type-filters .chip').forEach(b => b.addEventListener('click', () => { typeFilter = b.dataset.k; persist(); $$('#cpets-type-filters .chip').forEach(x => x.classList.toggle('is-active', x === b)); render(); }));
    $('#cpets-search').oninput = debounce(e => { query = e.target.value.trim(); persist(); render(); }, 280);
    load();
}
async function openCustomerPetDetail(id) {
    let p;
    try { p = await PetsAPI.get(id); } catch (err) { toast(err.message, 'error'); return; }
    $('#vp-name').innerHTML = `${p.imageUrl  ? `<img src="${p.imageUrl}"/>` : `<h2 class='vp-name'> ${petEmoji(p.type)} <h2>`} ${p.name}`;
    $('#vp-fields').innerHTML = `
    <div class="detail-row"><span class="k">Loại</span><span class="v">${p.type}</span></div>
    <div class="detail-row"><span class="k">Giống</span><span class="v">${escapeHtml(p.breed || '—')}</span></div>
    <div class="detail-row"><span class="k">Tuổi</span><span class="v">${p.age != null ? p.age + ' tuổi' : '—'}</span></div>
    <div class="detail-row"><span class="k">Cân nặng</span><span class="v">${p.weight != null ? p.weight + ' kg' : '—'}</span></div>
    <div class="detail-row"><span class="k">Trạng thái</span><span class="v">${petStatusBadge(p.status)}</span></div>`;
    openModal('modal-view-pet');
}

async function initCustomerBoarding() {
    const cards = $('#cbrec-cards');
    cards.innerHTML = `<div class="spinner-row"><span class="spinner"></span> Đang tải...</div>`;
    let rows = [];
    try { rows = await BoardingAPI.myActive(); } catch (err) { toast(err.message, 'error'); rows = []; }
    $('#cbrec-count').textContent = rows.length;
    if (!rows.length) { cards.innerHTML = `<div class="table-empty" style="grid-column:1/-1;">${ICONS.paw}<div>Hiện không có thú cưng nào đang gửi.</div></div>`; return; }
    cards.innerHTML = rows.map(item => {
        const r = item.record;
        const pet = r.petResponse || {};
        const overdue = item.daysRemaining <= 0 && r.expectedCheckOut && item.daysBoardedSoFar > daysBetween(r.checkInDate, r.expectedCheckOut);
        return `<div class="bcard">
      <div class="bcard__top">
        <div class="avatar-emoji" style="width:40px;height:40px;font-size:19px;">${pet.imageUrl  ? `<img src="${pet.imageUrl}"/>` : `${petEmoji(pet.type)}`}</div>
        <div><div class="cell-primary">${escapeHtml(pet.name || '—')}</div><div style="display:flex;gap:6px;align-items:center;"><span class="badge badge-home">${pet.type || ''}</span>${boardingBadge(r.status)}</div></div>
      </div>
      <div class="bcard__meta">${ICONS.calendar} Check-in: ${fmtDate(r.checkInDate)} · Dự kiến trả: ${fmtDate(r.expectedCheckOut)}</div>
      <div class="bcard__stats">
        <div class="bcard__stat"><span class="v">${Math.max(1, item.daysBoardedSoFar)} ngày</span><span class="l">Đã gửi</span></div>
        <div class="bcard__stat"><span class="v ${overdue ? 'warn' : ''}">${overdue ? 'Quá hạn' : item.daysRemaining + ' ngày'}</span><span class="l">Còn lại đến hạn</span></div>
        <div class="bcard__stat"><span class="v">${fmtVND(item.estimatedFee)}</span><span class="l">Tạm tính</span></div>
      </div>
      ${r.notes ? `<div class="pin-note" style="margin-bottom:12px;">${ICONS.note} ${escapeHtml(r.notes)}</div>` : ''}
      <div class="bcard__foot"><button class="btn btn-ghost btn-sm" data-view="${r.id}">${ICONS.note} Xem ghi chú chăm sóc</button></div>
    </div>`;
    }).join('');
    $$('[data-view]', cards).forEach(b => b.addEventListener('click', () => openCustomerBoardingDetail(b.dataset.view)));
}
async function openCustomerBoardingDetail(id) {
    let r;
    try { r = await BoardingAPI.get(id); } catch (err) { toast(err.message, 'error'); return; }
    $('#vb-fields').innerHTML = boardingDetailRows(r, { withOwner: false });
    $('#vb-notes-title').innerHTML = `${ICONS.note} GHI CHÚ CHĂM SÓC`;
    let notes = r.careNoteResponses;
    if (!notes) { try { notes = await CareNotesAPI.listByRecord(id); } catch (e) { notes = []; } }
    $('#vb-notes').innerHTML = careNotesHtml(notes);
    openModal('modal-view-boarding');
}

async function initCustomerHistory() {
    let all = [];
    try {
        all = (await BoardingAPI.myHistory()).slice().sort((a, b) => (b.checkInDate || '').localeCompare(a.checkInDate || ''));
    } catch (err) { toast(err.message, 'error'); }
    let query = Store.get('chist-filters', {}).query || '';
    $('#chist-search').value = query;
    function render() {
        const rows = query ? all.filter(r => (r.petResponse && r.petResponse.name || '').toLowerCase().includes(query.toLowerCase())) : all;
        $('#chist-count').textContent = rows.length;
        $('#chist-body').innerHTML = rows.length ? rows.map((r, i) => {
            const pet = r.petResponse || {};
            const days = r.status === 'BOARDING' ? stayDays(r.checkInDate, todayISO()) : stayDays(r.checkInDate, r.actualCheckOut);
            return `<tr>
        <td class="cell-sub">${i + 1}</td>
        <td><div class="avatar-cell"><div class="avatar-emoji">${pet.imageUrl  ? `<img src="${pet.imageUrl}"/>` : `${petEmoji(pet.type)}`}</div><div><div class="cell-primary">${escapeHtml(pet.name || '—')}</div><div class="cell-sub">${pet.type || ''}</div></div></div></td>
        <td>${fmtDate(r.checkInDate)}</td>
        <td>${r.actualCheckOut ? fmtDate(r.actualCheckOut) : '—'}</td>
        <td>${days ?? '—'} ngày</td>
        <td class="num cell-primary">${r.totalFee != null ? fmtVND(r.totalFee) : '—'}</td>
        <td>${boardingBadge(r.status)}</td>
        <td><button class="icon-btn" data-view="${r.id}" title="Xem">${ICONS.eye}</button></td>
      </tr>`;
        }).join('') : `<tr><td colspan="8"><div class="table-empty">${ICONS.scroll}<div>Chưa có lịch sử gửi nào.</div></div></td></tr>`;
        $$('[data-view]', $('#chist-body')).forEach(b => b.addEventListener('click', () => openCustomerBoardingDetail(b.dataset.view)));
    }
    $('#chist-search').oninput = debounce(e => { query = e.target.value.trim(); Store.set('chist-filters', { query }); render(); }, 280);
    render();
}

document.addEventListener('DOMContentLoaded', () => {
    $('#brand-paw').innerHTML = ICONS.paw;
    $$('.modal__close').forEach(b => { if (!b.innerHTML.trim()) b.innerHTML = ICONS.x; });

    loginFormV = bindForm([
        ['username', $('#username'), document.getElementById('username-err'), Rules.required],
        ['password', $('#password'), document.getElementById('password-err'), Rules.required],
    ], $('#submit-btn'));

    $('#login-form').addEventListener('submit', async (e) => {
        e.preventDefault();
        const username = $('#username').value.trim();
        const password = $('#password').value;
        const errBox = $('#login-error');
        const btn = $('#submit-btn');
        errBox.classList.remove('show');
        btn.disabled = true; btn.textContent = 'Đang đăng nhập…';
        try {
            await Auth.login(username, password);
            showApp();
        } catch (err) {
            errBox.textContent = err.message;
            errBox.classList.add('show');
        } finally {
            btn.disabled = false; btn.textContent = 'Đăng nhập';
        }
    });
	
    if (Auth.restoreSession()) showApp();
});
